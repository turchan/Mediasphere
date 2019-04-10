package com.turchanovskyi.mediasphere.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "materials")
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Long id_material;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "deadline")
    private Date deadline;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User id_author;

    @Column(name = "verified")
    private int verified;

    @Column(name = "registered")
    private Date registered;

    @Column(name = "views")
    private int views;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "materials_spheres",
                        joinColumns = @JoinColumn(name = "id_material"),
                        inverseJoinColumns = @JoinColumn(name = "id_sphere"))
    private List<Sphere> sphereList = new ArrayList<>();

    public Material() {}

    public Material(String title, String description, String location, Date deadline, User id_author, int verified, Date registered, int views, List<Sphere> sphereList) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.deadline = deadline;
        this.id_author = id_author;
        this.verified = verified;
        this.registered = registered;
        this.views = views;
        this.sphereList = sphereList;
    }

    public Long getId_material() {
        return id_material;
    }

    public void setId_material(Long id_material) {
        this.id_material = id_material;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public User getId_author() {
        return id_author;
    }

    public void setId_author(User id_author) {
        this.id_author = id_author;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public List<Sphere> getSphereList() {
        return sphereList;
    }

    public void setSphereList(List<Sphere> sphereList) {
        this.sphereList = sphereList;
    }
}
