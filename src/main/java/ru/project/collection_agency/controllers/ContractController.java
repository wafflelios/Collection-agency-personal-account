package ru.project.collection_agency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.project.collection_agency.entities.Contract;
import ru.project.collection_agency.entities.Role;
import ru.project.collection_agency.entities.User;
import ru.project.collection_agency.services.ContractService;
import ru.project.collection_agency.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class ContractController {

    private final ContractService contractService;
    private final UserService userService;

    @Autowired
    public ContractController(ContractService contractService, UserService userService) {
        this.contractService = contractService;
        this.userService = userService;
    }

    @GetMapping("/contracts/all")
    @ResponseBody
    public String getContracts()
    {
        StringBuilder result = new StringBuilder();
        List<Contract> contracts = contractService.getAllContracts();
        for (Contract contract : contracts) {
            result.append(contract.toString()).append("<br><br><br>");
        }
        return result.toString();
    }

    @GetMapping("/contracts/{id}")
    @ResponseBody
    public String getContractById(Principal currentUser, @PathVariable Long id)
    {
        try
        {
            User user = userService.getUserByUsername(currentUser.getName());
            if (user.getRoles().contains(Role.ADMIN))
            {
                return contractService.getContractById(id).toString();
            }
            else
            {
                if (user.getContracts().contains(contractService.getContractById(id))) {
                    return contractService.getContractById(id).toString();
                }
                else return "You don't have a contract with ID " + id;
            }
        }
        catch (Exception e)
        {
            return "You don't have a contract with ID " + id;
        }
    }

    @GetMapping("/home/contracts")
    @ResponseBody
    public String getUserContracts(Principal currentUser)
    {
        List<Contract> contracts = contractService.getContractsByUser(currentUser.getName());
        StringBuilder result = new StringBuilder();
        for (Contract contract : contracts) {
            result.append(contract.toString()).append("<br><br><br>");
        }
        return result.toString();
    }
}
