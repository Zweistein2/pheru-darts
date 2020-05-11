package de.pheru.darts.backend.mocks.repositories;


import de.pheru.darts.backend.entities.playerpermission.PlayerPermissionEntity;
import de.pheru.darts.backend.repositories.PlayerPermissionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockedPlayerPermissionRepository implements PlayerPermissionRepository {

    private int idCount = 0;
    private final List<PlayerPermissionEntity> playerPermissions = new ArrayList<>();

    @Override
    public List<PlayerPermissionEntity> findByUserId(final String userId) {
        final List<PlayerPermissionEntity> byUserId = new ArrayList<>();
        for (final PlayerPermissionEntity playerPermission : playerPermissions) {
            if (playerPermission.getUserId().equals(userId)) {
                byUserId.add(playerPermission);
            }
        }
        return byUserId;
    }

    @Override
    public List<PlayerPermissionEntity> findByPermittedUserId(final String permittedUserId) {
        final List<PlayerPermissionEntity> byUserId = new ArrayList<>();
        for (final PlayerPermissionEntity playerPermission : playerPermissions) {
            if (playerPermission.getPermittedUserId().equals(permittedUserId)) {
                byUserId.add(playerPermission);
            }
        }
        return byUserId;
    }

    @Override
    public PlayerPermissionEntity findByUserIdAndPermittedUserId(final String userId, final String permittedUserId) {
        for (final PlayerPermissionEntity playerPermission : playerPermissions) {
            if (playerPermission.getUserId().equals(userId) && playerPermission.getPermittedUserId().equals(permittedUserId)) {
                return playerPermission;
            }
        }
        return null;
    }

    @Override
    public List<PlayerPermissionEntity> deleteAllByUserId(final String userId) {
        playerPermissions.removeIf(savedEntity -> savedEntity.getUserId().equals(userId));
        return null;
    }

    @Override
    public List<PlayerPermissionEntity> deleteAllByPermittedUserId(final String permittedUserId) {
        playerPermissions.removeIf(savedEntity -> savedEntity.getPermittedUserId().equals(permittedUserId));
        return null;
    }

    @Override
    public <S extends PlayerPermissionEntity> S save(final S s) {
        playerPermissions.add(s);
        s.setId(String.valueOf(idCount));
        idCount++;
        return s;
    }

    @Override
    public <S extends PlayerPermissionEntity> Iterable<S> saveAll(final Iterable<S> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Optional<PlayerPermissionEntity> findById(final String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(final String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterable<PlayerPermissionEntity> findAll() {
        return playerPermissions;
    }

    @Override
    public Iterable<PlayerPermissionEntity> findAllById(final Iterable<String> iterable) {
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
    public void delete(final PlayerPermissionEntity playerPermissionEntity) {
        playerPermissions.removeIf(savedEntity -> savedEntity.getId().equals(playerPermissionEntity.getId()));
    }

    @Override
    public void deleteAll(final Iterable<? extends PlayerPermissionEntity> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not implemented");
    }
}