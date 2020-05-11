package de.pheru.darts.backend.repositories;

import de.pheru.darts.backend.entities.user.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, String> {

    List<UserEntity> findAllByIdIn(final Iterable<String> ids);

    UserEntity findByName(final String name);
}