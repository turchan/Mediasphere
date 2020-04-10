package com.turchanovskyi.mediasphere.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contacts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Long id_contact;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "information")
    private String information;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "workplace")
    private String workplace;

    @Column(name = "position")
    private String position;

    @Column(name = "location")
    private String location;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "registered")
    private Date registered;

    @Column(name = "price")
    private int price;

    @Column(name = "purchases")
    private int purchases;

    @JsonIgnoreProperties({"materialList", "reportList", "purchaseList", "notificationList", "contactList"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User id_user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contacts_spheres",
                        joinColumns = @JoinColumn(name = "id_contact"),
                        inverseJoinColumns = @JoinColumn(name = "id_sphere"))
    private List<Sphere> sphereList = new ArrayList<>();

    @JsonIgnoreProperties({"id_contact", "id_user"})
    @OneToMany(mappedBy = "id_contact", fetch = FetchType.LAZY)
    private List<Report> reportList = new ArrayList<>();

    @JsonIgnoreProperties("id_contact")
    @OneToMany(mappedBy = "id_contact", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Purchase> purchaseList = new ArrayList<>();

    public Contact() {}

    public Contact(String name, String surname, String information, String email, String phone, String workplace, String position, String location, String country, String city, Date registered, int price, int purchases, User id_user, List<Sphere> sphereList) {
        this.name = name;
        this.surname = surname;
        this.information = information;
        this.email = email;
        this.phone = phone;
        this.workplace = workplace;
        this.position = position;
        this.location = location;
        this.country = country;
        this.city = city;
        this.registered = registered;
        this.price = price;
        this.purchases = purchases;
        this.id_user = id_user;
        this.sphereList = sphereList;
    }

    public Contact(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.information = builder.information;
        this.email = builder.email;
        this.phone = builder.phone;
        this.workplace = builder.workplace;
        this.position = builder.position;
        this.location = builder.location;
        this.country = builder.country;
        this.city = builder.city;
        this.price = builder.price;
        this.id_user = builder.id_user;
    }

    public static class Builder {
        private Long id_contact;
        private String name;
        private String surname;
        private String information;
        private String email;
        private String phone;
        private String workplace;
        private String position;
        private String location;
        private String country;
        private String city;
        private int price;
        private User id_user;

        public Builder(Long id_contact, User id_user) {
            this.id_contact = id_contact;
            this.id_user = id_user;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setInformation(String information) {
            this.information = information;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setWorkplace(String workplace) {
            this.workplace = workplace;
            return this;
        }

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Contact build() {
            Contact contact = new Contact(this);

            return contact;
        }
    }

    public Long getId_contact() {
        return id_contact;
    }

    public void setId_contact(Long id_contact) {
        this.id_contact = id_contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public List<Sphere> getSphereList() {
        return sphereList;
    }

    public void setSphereList(List<Sphere> sphereList) {
        this.sphereList = sphereList;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }
}
