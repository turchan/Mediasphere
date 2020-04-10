package com.turchanovskyi.mediasphere.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reports")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_report")
    private Long id_report;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @JsonIgnoreProperties({"materialList", "reportList", "purchaseList", "notificationList", "contactList"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User id_user;

    @JsonIgnoreProperties({"materialList", "reportList", "purchaseList", "notificationList", "contactList"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contact")
    private Contact id_contact;

    @Column(name = "sent")
    private Date sent;

    public Report() {}

    public Report(Builder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.id_user = builder.id_user;
        this.id_contact = builder.id_contact;
    }

    public static class Builder {
        private Long id_report;
        private String title;
        private String content;
        private User id_user;
        private Contact id_contact;

        public Builder(Long id_report, User id_user, Contact id_contact) {
            this.id_report = id_report;
            this.id_user = id_user;
            this.id_contact = id_contact;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Report build() {
           Report report = new Report(this);

           return report;
        }
    }

    public Long getId_report() {
        return id_report;
    }

    public void setId_report(Long id_report) {
        this.id_report = id_report;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
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
