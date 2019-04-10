package com.turchanovskyi.mediasphere.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "notifications")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_notification")
    private Long id_notification;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_notification_type")
    private NotificationType id_type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User id_user;

    @Column(name = "occurred")
    private Date occurred;

    public Notification() { }

    public Notification(String name, String content, NotificationType id_type, User id_user, Date occurred) {
        this.name = name;
        this.content = content;
        this.id_type = id_type;
        this.id_user = id_user;
        this.occurred = occurred;
    }

    public Long getId_notification() {
        return id_notification;
    }

    public void setId_notification(Long id_notification) {
        this.id_notification = id_notification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotificationType getId_type() {
        return id_type;
    }

    public void setId_type(NotificationType id_type) {
        this.id_type = id_type;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public Date getOccurred() {
        return occurred;
    }

    public void setOccurred(Date occurred) {
        this.occurred = occurred;
    }
}
