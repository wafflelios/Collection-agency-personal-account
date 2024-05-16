package ru.project.collection_agency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.project.collection_agency.entities.Contract;
import ru.project.collection_agency.services.ContractService;

import java.util.List;

@Controller
public class ContractController {

    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }
    @GetMapping("/contracts/all")
    @ResponseBody
    public List<Contract> getContracts()
    {
        return contractService.getAllContracts();
    }

    @GetMapping("/contracts/find_by/contract_id/{id}")
    @ResponseBody
    public Contract getContractById(@PathVariable Long id)
    {
        return contractService.getContractById(id);
    }

    @GetMapping("/contracts/find_by/user_id/{id}")
    @ResponseBody
    public List<Contract> getContractByUserId(@PathVariable Long id)
    {
        return contractService.getContractByUserId(id);
    }

    @GetMapping("/contracts/find_by/debt_id/{id}")
    @ResponseBody
    public Contract getContractByDebtId(@PathVariable Long id)
    {
        return contractService.getContractsByDebtId(id);
    }
}
