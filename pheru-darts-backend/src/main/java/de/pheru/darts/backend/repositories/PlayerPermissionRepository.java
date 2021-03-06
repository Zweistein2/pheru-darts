package de.pheru.darts.backend.repositories;

import de.pheru.darts.backend.entities.playerpermission.PlayerPermissionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerPermissionRepository extends CrudRepository<PlayerPermissionEntity, String> {

    List<PlayerPermissionEntity> findByUserId(final String userId);

    List<PlayerPermissionEntity> findByPermittedUserId(final String permittedUserId);

    PlayerPermissionEntity findByUserIdAndPermittedUserId(final String userId, final String permittedUserId);

    List<PlayerPermissionEntity> deleteAllByUserId(final String userId);

    List<PlayerPermissionEntity> deleteAllByPermittedUserId(final String permittedUserId);
}
