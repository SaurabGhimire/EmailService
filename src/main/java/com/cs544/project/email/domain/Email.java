package com.cs544.project.email.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String to;
    private String from;
    private String subject;
    private String message;
    private List<String> cc;
    private List<String> bcc;
    private List<Attachment> attachments;
    private Date sentDate;

    @Data
    public static class Attachment {
        private String fileName;
        private byte[] fileContent;
        private String mimeType;
    }
}
