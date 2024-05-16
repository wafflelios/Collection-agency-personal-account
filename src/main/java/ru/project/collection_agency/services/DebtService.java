package ru.project.collection_agency.services;

import org.springframework.stereotype.Service;
import ru.project.collection_agency.entities.Debt;
import ru.project.collection_agency.repositories.DebtRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DebtService {

    protected final DebtRepository repository;

    public DebtService(DebtRepository debtRepository)
    {
        repository = debtRepository;
    }

    public List<Debt> getAllDebts()
    {
        List<Debt> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().toList();
    }

    public Debt getDebtById(Long id)
    {
        return repository.findById(id).get();
    }

    public List<Debt> getDebtsByUserId(Long id)
    {
        List<Debt> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().filter( debt -> debt.getDebtor().getId().equals(id)).toList();
    }

    public Debt getDebtsByContractId(Long id)
    {
        List<Debt> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().filter( debt -> debt.getContract().getId().equals(id)).toList().get(0);
    }
}
