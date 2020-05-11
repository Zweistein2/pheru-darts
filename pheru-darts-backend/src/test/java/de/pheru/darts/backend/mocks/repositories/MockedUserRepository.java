package de.pheru.darts.backend.mocks.repositories;

import de.pheru.darts.backend.entities.user.UserEntity;
import de.pheru.darts.backend.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MockedUserRepository extends MockedRepository implements UserRepository {

    private final List<UserEntity> users = new ArrayList<>();

    @Override
    public List<UserEntity> findAllByIdIn(final Iterable<String> ids) {
        final List<UserEntity> users = new ArrayList<>();
        for (final String id : ids) {
            final UserEntity user = findById(id).orElse(null);
            if (user != null) {
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public UserEntity findByName(final String name) {
        for (final UserEntity user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public <S extends UserEntity> S save(final S s) {
        users.add(s);
        if (s.getId() == null || s.getId().isEmpty()) {
            s.setId(increaseAndGetIdAsString());
        }
        return s;
    }

    @Override
    public <S extends UserEntity> Iterable<S> saveAll(final Iterable<S> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Optional<UserEntity> findById(final String id) {
        for (final UserEntity user : users) {
            if (user.getId().equals(id)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(final String id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<UserEntity> findAll() {
        return users;
    }

    @Override
    public Iterable<UserEntity> findAllById(final Iterable<String> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteById(final String id) {
        users.removeIf(savedEntity -> savedEntity.getId().equals(id));
    }

    @Override
    public void delete(final UserEntity userEntity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll(final Iterable<? extends UserEntity> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not implemented");
    }
}