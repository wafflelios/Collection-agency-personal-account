package ru.project.collection_agency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.project.collection_agency.entities.User;
import ru.project.collection_agency.services.EmailService;
import ru.project.collection_agency.services.UserService;

@Controller
public class RegistrationController
{
    private String verificationCode;

    private User user;

    private final UserService userService;

    private final EmailService emailService;

    @Autowired
    public RegistrationController( UserService userService, EmailService emailService)
    {
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String adduser(Model model, User user, String code)
    {
        User dbUser = userService.getUserByEmail(user.getEmail());
        if (dbUser == null)
        {
            verificationCode = emailService.generateVerificationCode();
            this.user = user;
            emailService.sendMessage(user.getEmail(), "Ваш код подтверждения:", verificationCode);
            return "redirect:/email-verification";
        }
        model.addAttribute("message", "User with this email already exists");
        return "registration";
    }

    @GetMapping("/email-verification")
    public String emailVerification()
    {
        return "emailVerification";
    }

    @PostMapping("/email-verification")
    public String verifyEmail(Model model, String code)
    {
        if (code.equals(verificationCode))
        {
            try
            {
                userService.addUser(user);
                return "redirect:/home";
            }
            catch (Exception ex)
            {
                model.addAttribute("message", "User exists");
                return "emailVerification";
            }
        }
        else
        {
            model.addAttribute("message", "Wrong verification code");
            return "emailVerification";
        }
    }
}
