package ru.project.collection_agency.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.project.collection_agency.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
