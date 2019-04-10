package com.turchanovskyi.mediasphere.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "spheres")
public class Sphere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sphere")
    private Long id_sphere;

    @Column(name = "name")
    private String name;

    // if it will be necessary  add connection ManyToMany for ContactList and MaterialList

    public Sphere() {}

    public Sphere(String name) {
        this.name = name;
    }

    public Long getId_sphere() {
        return id_sphere;
    }

    public void setId_sphere(Long id_sphere) {
        this.id_sphere = id_sphere;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
