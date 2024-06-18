package com.cs544.project.email;

import com.cs544.project.email.domain.Email;
import com.cs544.project.email.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmailServiceListener {
    @Autowired
    EmailService emailService;

    double result = 0.0;

    @JmsListener(destination = "${app.queues.email_queue}")
    public void receiveMessage(final String emailAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
//            new Sender().sendEmail();
            Email email = objectMapper.readValue(emailAsString, Email.class);
            emailService.create(email);
            System.out.println("JMS receiver received message:" + email);
        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + emailAsString+" to a Email object");
        } catch (Exception e){
            System.out.println(e);
        }
    }

}


