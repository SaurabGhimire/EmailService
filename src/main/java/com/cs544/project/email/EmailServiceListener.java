package com.cs544.project.email;

import com.cs544.project.email.domain.Email;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmailServiceListener {

    double result = 0.0;

    @JmsListener(destination = "${app.queues.email_queue}")
    public void receiveMessage(final String emailAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Email email = objectMapper.readValue(emailAsString, Email.class);
            System.out.println("JMS receiver received message:" + email);
        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + emailAsString+" to a Email object");
        }
    }

}


