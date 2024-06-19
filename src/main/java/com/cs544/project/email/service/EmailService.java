package com.cs544.project.email.service;

import com.cs544.project.email.domain.Email;
import com.cs544.project.email.repository.EmailRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    public void create(Email email) {
        emailRepository.save(email);
    }
}
