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

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type")
    private NotificationType id_type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User id_user;

    @Column(name = "occurred")
    private Date occurred;

    public Notification() { }

    public Notification(String title, String content, NotificationType id_type, User id_user, Date occurred) {
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
