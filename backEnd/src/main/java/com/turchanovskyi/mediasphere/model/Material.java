package com.turchanovskyi.mediasphere.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "materials")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @JsonIgnoreProperties({"materialList", "reportList", "purchaseList", "notificationList", "contactList"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User id_user;

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

    public Material(String title, String description, String location, Date deadline, User id_user, Date registered, int views, List<Sphere> sphereList) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.deadline = deadline;
        this.id_user = id_user;
        this.registered = registered;
        this.views = views;
        this.sphereList = sphereList;
    }

    public Material(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.location = builder.location;
        this.deadline = builder.deadline;
        this.id_user = builder.id_user;
    }

    public static class Builder {
        private Long id_material;
        private String title;
        private String description;
        private String location;
        private Date deadline;
        private User id_user;

        public Builder(Long id_material, User id_user) {
            this.id_material = id_material;
            this.id_user = id_user;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setDeadline(Date deadline) {
            this.deadline = deadline;
            return this;
        }

        public Material build() {
            Material material = new Material(this);

            return material;
        }
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

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
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
