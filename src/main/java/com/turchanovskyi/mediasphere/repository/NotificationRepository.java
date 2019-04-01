package com.turchanovskyi.mediasphere.repository;

import com.turchanovskyi.mediasphere.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
