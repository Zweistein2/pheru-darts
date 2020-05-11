package de.pheru.darts.backend.mocks.repositories;


import de.pheru.darts.backend.entities.notification.NotificationEntity;
import de.pheru.darts.backend.repositories.NotificationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockedNotificationRepository extends MockedRepository implements NotificationRepository {

    private final List<NotificationEntity> notifications = new ArrayList<>();

    @Override
    public List<NotificationEntity> findByUserIdOrderByTimestamp(final String userId) {
        final List<NotificationEntity> byUserId = new ArrayList<>();
        for (final NotificationEntity notification : notifications) {
            if (notification.getUserId().equals(userId)) {
                byUserId.add(notification);
            }
        }
        return byUserId;
    }

    @Override
    public List<NotificationEntity> findAllByIdIn(final Iterable<String> ids) {
        final List<NotificationEntity> byId = new ArrayList<>();
        for (final NotificationEntity notification : notifications) {
            for (final String id : ids) {
                if (notification.getId().equals(id)) {
                    byId.add(notification);
                }
            }
        }
        return byId;
    }

    @Override
    public List<NotificationEntity> deleteAllByUserId(final String userId) {
        notifications.removeIf(notification -> notification.getUserId().equals(userId));
        return null;
    }

    @Override
    public Iterable<NotificationEntity> findAll() {
        return notifications;
    }

    @Override
    public Iterable<NotificationEntity> findAllById(final Iterable<String> iterable) {
        return null;
    }

    @Override
    public <S extends NotificationEntity> S save(final S entity) {
        NotificationEntity alreadySaved = null;
        for (final NotificationEntity notification : notifications) {
            if (notification.getId().equals(entity.getId())) {
                alreadySaved = notification;
            }
        }
        if (alreadySaved != null) {
            entity.setId(alreadySaved.getId());
            notifications.remove(alreadySaved);
        } else {
            entity.setId(increaseAndGetIdAsString());
        }
        notifications.add(entity);
        return entity;
    }

    @Override
    public <S extends NotificationEntity> Iterable<S> saveAll(final Iterable<S> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Optional<NotificationEntity> findById(final String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(final String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteById(final String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void delete(final NotificationEntity entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll(final Iterable<? extends NotificationEntity> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not implemented");
    }
}