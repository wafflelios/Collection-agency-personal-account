package ru.project.collection_agency.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.project.collection_agency.entities.Debt;
import ru.project.collection_agency.entities.Gender;
import ru.project.collection_agency.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class UserService
{
    private List<User> users = new ArrayList<>();

    public UserService()
    {
        init();
    }

    protected void init() {
        users.add(new User("Ksenia", "Gomzikova", "Andreevna",
                new Date(2003, 8, 13), Gender.Female, 8972227971L,
                3293, "London", new Date(2024, 4, 25),
                "917-219", "London", new ArrayList<>()));
    }

    public List<User> getAllUsers()
    {
        return users;
    }
}
