package de.pheru.darts.backend.mocks.repositories;

import de.pheru.darts.backend.entities.game.GameEntity;
import de.pheru.darts.backend.repositories.GameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockedGameRepository extends MockedRepository implements GameRepository {

    private final List<GameEntity> games = new ArrayList<>();

    @Override
    public List<GameEntity> findByUserId(final String userId) {
        final List<GameEntity> gamesByUserId = new ArrayList<>();
        for (final GameEntity game : games) {
            if (game.getUserId().equals(userId)) {
                gamesByUserId.add(game);
            }
        }
        return gamesByUserId;
    }

    @Override
    public List<GameEntity> deleteAllByUserId(final String userId) {
        games.removeIf(game -> game.getUserId().equals(userId));
        return null;
    }

    @Override
    public <S extends GameEntity> S save(final S s) {
        games.add(s);
        if (s.getId() == null || s.getId().isEmpty()) {
            s.setId(increaseAndGetIdAsString());
        }
        return s;
    }

    @Override
    public <S extends GameEntity> Iterable<S> saveAll(final Iterable<S> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Optional<GameEntity> findById(final String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(final String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterable<GameEntity> findAll() {
        return games;
    }

    @Override
    public Iterable<GameEntity> findAllById(final Iterable<String> iterable) {
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
    public void delete(final GameEntity gameEntity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll(final Iterable<? extends GameEntity> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not implemented");
    }
}