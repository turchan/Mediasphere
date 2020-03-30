package com.turchanovskyi.mediasphere.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id_user;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

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

    @Column(name = "phone")
    private String phone;

    @Column(name = "points")
    private int points;

    @Column(name = "password")
    private String password;

    @Column(name = "vk")
    private String vk;

    @Column(name = "fb")
    private String fb;

    @Column(name = "twitter")
    private String twitter;

    @Column(name = "website")
    private String website;

    @Column(name = "registered")
    private Date registered;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    //private String providerId;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
                joinColumns = @JoinColumn(name = "id_user"),
                inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "id_user", fetch = FetchType.LAZY)
    private List<Material> materialList = new ArrayList<>();

    @OneToMany(mappedBy = "id_user", fetch = FetchType.LAZY)
    private List<Report> reportList = new ArrayList<>();

    @OneToMany(mappedBy = "id_user", fetch = FetchType.LAZY)
    private List<Purchase> purchaseList = new ArrayList<>();

    @OneToMany(mappedBy = "id_notification", fetch = FetchType.LAZY)
    private List<Notification> notificationList = new ArrayList<>();

    @OneToMany(mappedBy = "id_user", fetch = FetchType.LAZY)
    private List<Contact> contactList = new ArrayList<>();

    public User() { }

    public User(String name, String surname, String email, String workplace, String position, String location, String country, String city, String phone, int points, String password, String vk, String fb, String twitter, String website, Date registered, Set<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.workplace = workplace;
        this.position = position;
        this.location = location;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.points = points;
        this.password = password;
        this.vk = vk;
        this.fb = fb;
        this.twitter = twitter;
        this.website = website;
        this.registered = registered;
        this.roles = roles;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(AuthProvider provider) {
        this.provider = provider;
    }

    //public String getProviderId() {
      //  return providerId;
    //}

    //public void setProviderId(String providerId) {
     //   this.providerId = providerId;
    //}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
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

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
