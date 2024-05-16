package ru.project.collection_agency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.project.collection_agency.entities.Debt;
import ru.project.collection_agency.services.DebtService;

import java.util.List;

@Controller
public class DebtController {

    private final DebtService debtService;

    @Autowired
    public DebtController(DebtService debtService) {
        this.debtService = debtService;
    }
    @GetMapping("/debts/all")
    @ResponseBody
    public List<Debt> getDebts()
    {
        return debtService.getAllDebts();
    }

    @GetMapping("/debts/find_by/debt_id/{id}")
    @ResponseBody
    public Debt getDebtById(@PathVariable Long id)
    {
        return debtService.getDebtById(id);
    }

    @GetMapping("/debts/find_by/user_id/{id}")
    @ResponseBody
    public List<Debt> getDebtsByUserId(@PathVariable Long id)
    {
        return debtService.getDebtsByUserId(id);
    }

    @GetMapping("/debts/find_by/contract_id/{id}")
    @ResponseBody
    public Debt getDebtByContractId(@PathVariable Long id)
    {
        return debtService.getDebtsByContractId(id);
    }
}
