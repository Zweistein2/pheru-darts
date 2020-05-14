package de.pheru.darts.backend.repositories;

import de.pheru.darts.backend.entities.game.GameEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameRepositoryService {
    private final GameRepository gameRepository;

    public GameRepositoryService(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameEntity> getGamesWithUser(final String loggedInUserId) {
        final List<GameEntity> allGames = (List<GameEntity>) gameRepository.findAll();
        return allGames.stream().filter(gameEntity -> gameEntity.getPlayers().stream()
                                                                .anyMatch(playerDocument -> playerDocument.getPlayerId().equals(loggedInUserId))).collect(
                Collectors.toList());
    }
}
