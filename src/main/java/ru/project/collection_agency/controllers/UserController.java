package ru.project.collection_agency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/allUsers")
    @ResponseBody
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }
}
