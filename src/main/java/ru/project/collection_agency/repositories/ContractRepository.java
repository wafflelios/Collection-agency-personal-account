package ru.project.collection_agency.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.project.collection_agency.entities.Contract;

public interface ContractRepository extends CrudRepository<Contract, Long>
{
}
