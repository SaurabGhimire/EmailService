package com.cs544.project.email;

import com.cs544.project.email.adapter.EmailAdapter;
import com.cs544.project.email.domain.Email;
import com.cs544.project.email.dto.EmailOutgoingRequest;
import com.cs544.project.email.integration.Sender;
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

    @Autowired
            Sender sender;

    double result = 0.0;

    @JmsListener(destination = "${app.queues.email_queue}")
    public void receiveMessage(final String emailAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Email email = objectMapper.readValue(emailAsString, Email.class);
            emailService.create(email);
            sender.sendEmail(email);
            // TODO: May be add a flag in DB to denote whether the email has been sent successfully or not
            System.out.println("JMS receiver received message:" + email);
        } catch (IOException e) {
            // TODO: Use Logger?
            System.out.println("JMS receiver: Cannot convert : " + emailAsString+" to a Email object");
        } catch (Exception e){
            // TODO: Use Logger? or redo email sending operation after t minutes
            System.out.println(e);
        }
    }

}


