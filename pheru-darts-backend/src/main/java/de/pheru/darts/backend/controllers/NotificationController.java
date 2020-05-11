package de.pheru.darts.backend.controllers;

import de.pheru.darts.backend.Logger;
import de.pheru.darts.backend.dtos.notification.NotificationDto;
import de.pheru.darts.backend.dtos.notification.NotificationModificationDto;
import de.pheru.darts.backend.entities.notification.NotificationEntity;
import de.pheru.darts.backend.exceptions.ForbiddenException;
import de.pheru.darts.backend.mappers.EntityToDtoMapper;
import de.pheru.darts.backend.repositories.NotificationRepository;
import de.pheru.darts.backend.security.SecurityUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private static final Logger LOGGER = new Logger(NotificationController.class);

    private final NotificationRepository notificationRepository;

    public NotificationController(final NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping
    public List<NotificationDto> get() {
        final List<NotificationEntity> notifications = notificationRepository.findByUserIdOrderByTimestamp(SecurityUtil.getLoggedInUserId());
        return EntityToDtoMapper.toNotificationDto(notifications);
    }

    @PutMapping
    public List<NotificationDto> put(@RequestBody final NotificationModificationDto notificationModification) {
        final List<String> ids = notificationModification.getIds();
        final List<NotificationEntity> notifications = notificationRepository.findAllByIdIn(ids);

        checkUserIds(notifications);

        final List<NotificationEntity> savedNotificationsList = new ArrayList<>();

        for (final NotificationEntity notification : notifications) {
            notification.setRead(notificationModification.isRead());
            savedNotificationsList.add(notificationRepository.save(notification));
        }

        return EntityToDtoMapper.toNotificationDto(savedNotificationsList);
    }

    private void checkUserIds(final List<NotificationEntity> notifications) {
        final String loggedInUserId = SecurityUtil.getLoggedInUserId();
        for (final NotificationEntity notification : notifications) {
            if (!notification.getUserId().equals(loggedInUserId)) {
                final String msg = "Not allowed to modify notification.";
                LOGGER.warn(msg + " notification-id: " + notification.getId() + ", user-id: " + loggedInUserId);
                throw new ForbiddenException(msg);
            }
        }
    }

}