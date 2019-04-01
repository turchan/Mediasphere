package com.turchanovskyi.mediasphere.service;

import com.turchanovskyi.mediasphere.model.Notification;

public interface NotificationService {

    Iterable<Notification> findAll();
    Notification findById(Long id);
    Notification save(Notification notification);
    void deleteById(Long id);
}
