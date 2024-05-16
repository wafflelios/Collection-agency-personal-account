package ru.project.collection_agency.services;

import org.springframework.stereotype.Service;
import ru.project.collection_agency.entities.Contract;
import ru.project.collection_agency.entities.Debt;
import ru.project.collection_agency.entities.Gender;
import ru.project.collection_agency.entities.User;
import ru.project.collection_agency.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class UserService
{
    protected final UserRepository repository;

    public UserService(UserRepository userRepository)
    {
        repository = userRepository;
    }

    public List<User> getAllUsers()
    {
        List<User> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().toList();
    }

    public void addUser(String firstName, String lastName, String patronymic, Date birthDate, Gender gender,
                        Long passportSeries, Integer passportNumber, String passportIssued, Date dateOfIssue,
                        String departmentCode, String location, List<Debt> debts, List<Contract> contracts)
    {
        User newUser = new User(firstName, lastName, patronymic, birthDate, gender, passportSeries, passportNumber,
                passportIssued, dateOfIssue, departmentCode, location, debts, contracts);
        repository.save(newUser);
    }
}
