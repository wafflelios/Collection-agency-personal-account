package ru.project.collection_agency.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailService
{
    JavaMailSender emailSender;

    public EmailService (JavaMailSender emailSender)
    {
        this.emailSender = emailSender;
    }

    public void sendMessage(String to, String subject, String text)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("k8749553@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        this.emailSender.send(message);
    }

    public String generateVerificationCode()
    {
        StringBuilder code = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 6; i++)
        {
            code.append(rand.nextInt(10));
        }
        return code.toString();
    }
}
