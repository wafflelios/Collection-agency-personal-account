package ru.project.collection_agency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.project.collection_agency.entities.*;
import ru.project.collection_agency.services.UserService;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public String getUsers()
    {
        StringBuilder result = new StringBuilder();
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            result.append(user.toString()).append("<br><br><br>");
        }
        return result.toString();
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public String getUsers(@PathVariable Long id)
    {
        return userService.getUserById(id).toString();
    }

    @GetMapping(value = "/home")
    @ResponseBody
    public String getCurrentUser(Principal currentUser) {
        return userService.getUserByUsername(currentUser.getName()).toString();
    }

    @GetMapping(value = "/edit-info")
    public String editInfo()
    {
        return "editInfo";
    }

    @PostMapping(value = "/edit-info")
    public String editPersonalInfo(Principal currentUser, String firstname, String lastname, String patronymic,
                                   String birthDate, String gender, String series, String number, String issued,
                                   String dateOfIssue, String departmentCode, String location)
    {
        User user = userService.getUserByUsername(currentUser.getName());
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPatronymic(patronymic);
        user.setBirthDate(userService.StringToDate(birthDate));
        if (gender.equals("Male"))
        {
            user.setGender(Gender.MALE);
        }
        else user.setGender(Gender.FEMALE);
        user.setSeries(Long.parseLong(series));
        user.setNumber(Integer.parseInt(number));
        user.setIssued(issued);
        user.setDateOfIssue(userService.StringToDate(dateOfIssue));
        user.setDepartmentCode(departmentCode);
        user.setLocation(location);
        userService.updateUser(user);
        return "redirect:/home";
    }

    @GetMapping(value = "/become-admin")
    public String becomeAdmin()
    {
        return "becomeAdmin";
    }

    @PostMapping(value = "/become-admin")
    public String enterCodeToBecomeAdmin(Model model, Principal currentUser, String code)
    {
        if (code.equals("111111"))
        {
            Set<Role> roles = new HashSet<>();
            roles.add(Role.USER);
            roles.add(Role.ADMIN);
            User user = userService.getUserByUsername(currentUser.getName());
            user.setRoles(roles);
            userService.updateUser(user);
            return "redirect:/home";
        }
        else
        {
            model.addAttribute("message", "Wrong code");
            return "becomeAdmin";
        }
    }

    @GetMapping(value = "/hello-world")
    @ResponseBody
    public String helloWorld() {
        return "hello world";
    }
}
