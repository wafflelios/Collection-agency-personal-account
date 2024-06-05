package ru.project.collection_agency.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.collection_agency.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
    User findByEmail(String email);
}
