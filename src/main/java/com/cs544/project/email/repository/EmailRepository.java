package com.cs544.project.email.repository;

import com.cs544.project.email.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Integer> {
}
