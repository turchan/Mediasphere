package com.turchanovskyi.mediasphere.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "purchases")
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_purchase")
    private Long id_purchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User id_user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contact")
    private Contact id_contact;

    public Purchase() {}

    public Purchase(User id_user, Contact id_contact) {
        this.id_user = id_user;
        this.id_contact = id_contact;
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
