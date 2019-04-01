package com.turchanovskyi.mediasphere.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_report")
    private Long id_report;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User id_sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contact")
    private Contact id_contact;

    @Column(name = "sent")
    private Date sent;

    public Report() {}

    public Report(String name, String content, User id_sender, Contact id_contact, Date sent) {
        this.name = name;
        this.content = content;
        this.id_sender = id_sender;
        this.id_contact = id_contact;
        this.sent = sent;
    }

    public Long getId_report() {
        return id_report;
    }

    public void setId_report(Long id_report) {
        this.id_report = id_report;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getId_sender() {
        return id_sender;
    }

    public void setId_sender(User id_sender) {
        this.id_sender = id_sender;
    }

    public Contact getId_contact() {
        return id_contact;
    }

    public void setId_contact(Contact id_contact) {
        this.id_contact = id_contact;
    }

    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }
}
