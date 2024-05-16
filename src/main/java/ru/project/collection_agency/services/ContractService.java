package ru.project.collection_agency.services;

import org.springframework.stereotype.Service;
import ru.project.collection_agency.entities.Contract;
import ru.project.collection_agency.repositories.ContractRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService {

    protected final ContractRepository repository;

    public ContractService(ContractRepository contractRepository)
    {
        repository = contractRepository;
    }

    public List<Contract> getAllContracts()
    {
        List<Contract> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().toList();
    }

    public Contract getContractById(Long id)
    {
        return repository.findById(id).get();
    }

    public List<Contract> getContractByUserId(Long id)
    {
        List<Contract> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().filter( contract -> contract.getContractor().getId().equals(id)).toList();
    }

    public Contract getContractsByDebtId(Long id)
    {
        List<Contract> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().filter( contract -> contract.getDebt().getId().equals(id)).toList().get(0);
    }
}
