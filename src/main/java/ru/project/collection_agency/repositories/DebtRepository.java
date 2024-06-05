package ru.project.collection_agency.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.collection_agency.entities.Debt;

@Repository
public interface DebtRepository extends CrudRepository<Debt, Long> {
}
