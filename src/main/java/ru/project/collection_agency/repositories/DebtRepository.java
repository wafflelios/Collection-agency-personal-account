package ru.project.collection_agency.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.project.collection_agency.entities.Debt;

public interface DebtRepository extends CrudRepository<Debt, Long> {
}
