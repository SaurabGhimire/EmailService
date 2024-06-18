package com.cs544.project.email.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String emailTo;
    private String emailFrom;
    private String subject;
    private String message;

    @ElementCollection
    @CollectionTable(name = "email_cc", joinColumns = @JoinColumn(name = "email_id"))
    @Column(name = "cc_email")
    private Collection<String> cc;

    @ElementCollection
    @CollectionTable(name = "email_bcc", joinColumns = @JoinColumn(name = "email_id"))
    @Column(name = "bcc_email")
    private Collection<String> bcc;

    // Uncomment and adjust if you add attachments
    // private List<Attachment> attachments;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;
}