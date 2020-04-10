package com.turchanovskyi.mediasphere.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "purchases")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase")
    private Long id_purchase;

    @JsonIgnoreProperties({"materialList", "reportList", "purchaseList", "notificationList", "contactList"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User id_user;

    @JsonIgnoreProperties({"materialList", "reportList", "purchaseList", "notificationList", "contactList"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contact")
    private Contact id_contact;

    public Purchase() {}

    public Purchase(User id_user, Contact id_contact) {
        this.id_user = id_user;
        this.id_contact = id_contact;
    }

    public Purchase(Builder builder) {
        this.id_user = builder.id_user;
        this.id_contact = builder.id_contact;
    }

    public static class Builder {
        private Long id_purchase;
        private User id_user;
        private Contact id_contact;

        public Builder(Long id_purchase, User id_user, Contact id_contact) {
            this.id_purchase = id_purchase;
            this.id_user = id_user;
            this.id_contact = id_contact;
        }

        public Purchase build() {
            Purchase purchase = new Purchase(this);

            return purchase;
        }
    }

    public Long getId_purchase() {
        return id_purchase;
    }

    public void setId_purchase(Long id_purchase) {
        this.id_purchase = id_purchase;
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
}
