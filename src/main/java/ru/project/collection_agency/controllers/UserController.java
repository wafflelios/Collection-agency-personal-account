package ru.project.collection_agency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.project.collection_agency.entities.User;
import ru.project.collection_agency.services.UserService;

import java.util.List;

@Controller
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users/all")
    @ResponseBody
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public User getUsers(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }
}
