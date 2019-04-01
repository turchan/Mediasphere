package com.turchanovskyi.mediasphere.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notifications_types")
public class NotificationType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_notification_type")
    private Long id_notification_type;

    @Column(name = "name")
    private NotificationTypeName notificationTypeName;

    public NotificationType() {}

    public NotificationType(NotificationTypeName notificationTypeName) {
        this.notificationTypeName = notificationTypeName;
    }

    public Long getId_notification_type() {
        return id_notification_type;
    }

    public void setId_notification_type(Long id_notification_type) {
        this.id_notification_type = id_notification_type;
    }

    public NotificationTypeName getNotificationTypeName() {
        return notificationTypeName;
    }

    public void setNotificationTypeName(NotificationTypeName notificationTypeName) {
        this.notificationTypeName = notificationTypeName;
    }
}
