package com.turchanovskyi.mediasphere.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private int id_role;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleName name;

    public Role() {}

    public Role(RoleName name) {
        this.name = name;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public RoleName getName() {
        return name;
    }

    public void setRoleName(RoleName name) {
        this.name = name;
    }
}
