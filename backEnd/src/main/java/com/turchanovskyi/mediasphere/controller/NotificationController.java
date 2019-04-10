package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.model.Notification;
import com.turchanovskyi.mediasphere.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public Iterable<Notification> getAll()
    {
        return notificationService.findAll();
    }

    @GetMapping("/{notificationId}")
    public Notification getMaterial(@PathVariable Long notificationId)
    {
        return notificationService.findById(notificationId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Notification create(@RequestBody Notification notification)
    {
        notification.setId_notification(null);

        notificationService.save(notification);

        return notification;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Notification update(@RequestBody Notification notification)
    {
        notificationService.save(notification);

        return notification;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{notificationId}")
    public void delete(@PathVariable Long notificationId)
    {
        notificationService.deleteById(notificationId);
    }
}
