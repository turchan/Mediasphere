package com.turchanovskyi.mediasphere.implementation;

import com.turchanovskyi.mediasphere.model.Notification;
import com.turchanovskyi.mediasphere.repository.NotificationRepository;
import com.turchanovskyi.mediasphere.service.NotificationService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Iterable<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification findById(Long id) {
        return notificationRepository.findById(id).get();
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }
}
