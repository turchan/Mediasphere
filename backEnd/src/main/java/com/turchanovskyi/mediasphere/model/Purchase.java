package com.turchanovskyi.mediasphere.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "purchases")
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_purchases")
    private Long id_purchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User id_buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contact")
    private Contact id_contact;

    public Purchase() {}

    public Purchase(User id_buyer, Contact id_contact) {
        this.id_buyer = id_buyer;
        this.id_contact = id_contact;
    }

    public Long getId_purchase() {
        return id_purchase;
    }

    public void setId_purchase(Long id_purchase) {
        this.id_purchase = id_purchase;
    }

    public User getId_buyer() {
        return id_buyer;
    }

    public void setId_buyer(User id_buyer) {
        this.id_buyer = id_buyer;
    }

    public Contact getId_contact() {
        return id_contact;
    }

    public void setId_contact(Contact id_contact) {
        this.id_contact = id_contact;
    }
}
