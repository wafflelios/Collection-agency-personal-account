package ru.project.collection_agency.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.collection_agency.entities.Contract;

import java.util.List;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long>
{
}
