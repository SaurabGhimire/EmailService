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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "email_user_to",
            joinColumns = @JoinColumn(name = "email_user_to"),
            inverseJoinColumns = @JoinColumn(name = "email_user_id"))
    private Collection<EmailUser> emailTo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_user_from_id", referencedColumnName = "id")
    private EmailUser emailFrom;
    private String subject;
    private String text;
    private String category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "email_cc",
            joinColumns = @JoinColumn(name = "email_cc_id"),
            inverseJoinColumns = @JoinColumn(name = "email_user_id"))
    private Collection<EmailUser> cc;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "email_bcc",
            joinColumns = @JoinColumn(name = "email_bcc_id"),
            inverseJoinColumns = @JoinColumn(name = "email_user_id"))
    private Collection<EmailUser> bcc;

    // Uncomment and adjust if you add attachments
    // private List<Attachment> attachments;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;
}