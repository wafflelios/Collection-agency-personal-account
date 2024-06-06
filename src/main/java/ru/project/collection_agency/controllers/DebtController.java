package ru.project.collection_agency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.project.collection_agency.entities.Contract;
import ru.project.collection_agency.entities.Debt;
import ru.project.collection_agency.entities.Role;
import ru.project.collection_agency.entities.User;
import ru.project.collection_agency.services.ContractService;
import ru.project.collection_agency.services.DebtService;
import ru.project.collection_agency.services.UserService;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class DebtController {

    private final DebtService debtService;
    private final UserService userService;
    private final ContractService contractService;

    @Autowired
    public DebtController(DebtService debtService, UserService userService, ContractService contractService) {
        this.debtService = debtService;
        this.userService = userService;
        this.contractService = contractService;
    }
    @GetMapping("/debts/all")
    @ResponseBody
    public String getDebts()
    {
        StringBuilder result = new StringBuilder();
        List<Debt> debts = debtService.getAllDebts();
        for (Debt debt : debts) {
            result.append(debt.toString()).append("<br><br><br>");
        }
        return result.toString();
    }

    @GetMapping("/debts/{id}")
    @ResponseBody
    public String getDebtById(Principal currentUser, @PathVariable Long id)
    {
        try
        {
            User user = userService.getUserByUsername(currentUser.getName());
            if (user.getRoles().contains(Role.ADMIN))
            {
                return debtService.getDebtById(id).toString();
            }
            else
            {
                if (user.getDebts().contains(debtService.getDebtById(id))){
                    return debtService.getDebtById(id).toString();
                }
                return "You don't have a debt with ID " + id;
            }
        }
        catch (Exception e)
        {
            return "You don't have a debt with ID " + id;
        }
    }

    @GetMapping("/home/debts")
    @ResponseBody
    public String getUserDebts(Principal currentUser)
    {
        List<Debt> debts = debtService.getDebtsByUser(currentUser.getName());
        StringBuilder result = new StringBuilder();
        for (Debt debt : debts) {
            result.append(debt.toString()).append("<br><br><br>");
        }
        return result.toString();
    }

    @GetMapping("/home/debts/repaid")
    @ResponseBody
    public String getRepaidUserDebts(Principal currentUser)
    {
        List<Debt> debts = debtService.getDebtsByUser(currentUser.getName());
        StringBuilder result = new StringBuilder();
        for (Debt debt : debts) {
            if (debt.isRepaid()) result.append(debt.toString()).append("<br><br><br>");
        }
        return result.toString();
    }

    @GetMapping("/home/debts/not-repaid")
    @ResponseBody
    public String getNotRepaidUserDebts(Principal currentUser)
    {
        List<Debt> debts = debtService.getDebtsByUser(currentUser.getName());
        StringBuilder result = new StringBuilder();
        for (Debt debt : debts) {
            if (!debt.isRepaid()) result.append(debt.toString()).append("<br><br><br>");
        }
        return result.toString();
    }

    @GetMapping("/debts/add")
    public String addDebt()
    {
        return "addDebt";
    }

    @PostMapping("/debts/add")
    public String addDebt(String debtorUsername, String amount, String creditor, String contractConditions)
    {
        User user = userService.getUserByUsername(debtorUsername);
        Debt debt = new Debt(user, null, Double.parseDouble(amount), creditor, false);
        debtService.addDebt(debt);
        Contract contract = new Contract(user, debt, new Date(), contractConditions);
        contractService.addContract(contract);
        debt.setContract(contract);
        List<Debt> debts = user.getDebts();
        List<Contract> contracts = user.getContracts();
        debts.add(debt);
        contracts.add(contract);
        userService.updateUser(user);
        debtService.addDebt(debt);
        contractService.addContract(contract);
        return "redirect:/users/all";
    }

    @GetMapping("/debts/{id}/repaid")
    public String repaidDebt(@PathVariable Long id)
    {
        Debt debt = debtService.getDebtById(id);
        debt.setRepaid(true);
        debtService.addDebt(debt);
        return "redirect:/debts/all";
    }
}
