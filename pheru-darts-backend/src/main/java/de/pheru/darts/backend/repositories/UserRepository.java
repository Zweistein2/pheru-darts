package de.pheru.darts.backend.repositories;

import de.pheru.darts.backend.entities.UserEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, String> {

    UserEntity findById(final String id);

    // TODO sollte nicht nötig sein, da Hashkey; ohne kommt aber Exception
    @EnableScan
    List<UserEntity> findByIdIn(final List<String> ids);

    UserEntity findByName(final String name);

    void deleteById(final String id);

}
