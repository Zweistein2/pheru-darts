package de.pheru.darts.backend.controllers;

import de.pheru.darts.backend.dtos.UserDto;
import de.pheru.darts.backend.entities.PlayerPermissionEntity;
import de.pheru.darts.backend.entities.UserEntity;
import de.pheru.darts.backend.exceptions.PermissionAlreadyGrantedException;
import de.pheru.darts.backend.exceptions.UserNotFoundException;
import de.pheru.darts.backend.mocks.repositories.MockedPlayerPermissionRepository;
import de.pheru.darts.backend.mocks.repositories.MockedUserRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlayerPermissionControllerTest extends ControllerTest {

    private PlayerPermissionController playerPermissionController;

    @Before
    public void setUp() {
        playerPermissionController = new PlayerPermissionController(playerPermissionRepository, userRepository);
    }

    @Test
    public void post() {
        final UserEntity savedUser = userRepository.save(createDefaultUserEntity());
        playerPermissionController.post(savedUser.getId());

        final Iterable<PlayerPermissionEntity> all = playerPermissionRepository.findAll();
        assertTrue(all.iterator().hasNext());

        final PlayerPermissionEntity entity = all.iterator().next();
        assertEquals(LOGIN_ID, entity.getUserId());
        assertEquals(savedUser.getId(), entity.getPermittedUserId());
    }

    @Test
    public void postUserDoesNotExist() {
        try {
            playerPermissionController.post("gibtsnicht");
            fail("Exception expected");
        } catch (final UserNotFoundException e) {
            final Iterable<PlayerPermissionEntity> all = playerPermissionRepository.findAll();
            assertFalse(all.iterator().hasNext());
        }
    }

    @Test
    public void postPermissionAlreadyGranted() {
        final UserEntity savedUser = userRepository.save(createDefaultUserEntity());
        savePlayerPermission(LOGIN_ID, savedUser.getId());

        try {
            playerPermissionController.post(savedUser.getId());
            fail("Exception expected");
        } catch (final PermissionAlreadyGrantedException e) {
            final List<PlayerPermissionEntity> all = (List<PlayerPermissionEntity>) playerPermissionRepository.findAll();
            assertEquals(1, all.size());
        }
    }

    @Test
    public void delete() {
        final UserEntity savedUser = userRepository.save(createDefaultUserEntity());
        savePlayerPermission(LOGIN_ID, savedUser.getId());

        final Iterable<PlayerPermissionEntity> allBefore = playerPermissionRepository.findAll();
        assertTrue(allBefore.iterator().hasNext());

        playerPermissionController.delete(savedUser.getId());

        final Iterable<PlayerPermissionEntity> allAfter = playerPermissionRepository.findAll();
        assertFalse(allAfter.iterator().hasNext());
    }

    @Test
    public void getPermittedUsers() {
        final UserEntity loggedInUser = createDefaultUserEntity();
        loggedInUser.setId(LOGIN_ID);
        userRepository.save(loggedInUser);
        savePlayerPermission(LOGIN_ID, LOGIN_ID);

        final List<UserDto> permittedUsers = playerPermissionController.getPermittedUsers();
        assertEquals(1, permittedUsers.size());
        assertEquals(LOGIN_ID, permittedUsers.get(0).getId());

        final UserEntity savedUser1 = userRepository.save(createDefaultUserEntity());
        final UserEntity savedUser2 = userRepository.save(createDefaultUserEntity());
        final UserEntity savedUser3 = userRepository.save(createDefaultUserEntity());
        savePlayerPermission(LOGIN_ID, savedUser1.getId());
        savePlayerPermission(LOGIN_ID, savedUser2.getId());
        savePlayerPermission(LOGIN_ID, savedUser3.getId());

        final List<UserDto> permittedUsersAfterSave = playerPermissionController.getPermittedUsers();
        assertEquals(4, permittedUsersAfterSave.size());
        assertEquals(LOGIN_ID, permittedUsersAfterSave.get(0).getId());
        assertEquals(savedUser1.getId(), permittedUsersAfterSave.get(1).getId());
        assertEquals(savedUser2.getId(), permittedUsersAfterSave.get(2).getId());
        assertEquals(savedUser3.getId(), permittedUsersAfterSave.get(3).getId());
    }

    @Test
    public void getPlayableUsers() {
        final UserEntity loggedInUser = createDefaultUserEntity();
        loggedInUser.setId(LOGIN_ID);
        userRepository.save(loggedInUser);
        savePlayerPermission(LOGIN_ID, LOGIN_ID);

        final List<UserDto> playableUsers = playerPermissionController.getPlayableUsers();
        assertEquals(1, playableUsers.size());
        assertEquals(LOGIN_ID, playableUsers.get(0).getId());

        final UserEntity savedUser1 = userRepository.save(createDefaultUserEntity());
        final UserEntity savedUser2 = userRepository.save(createDefaultUserEntity());
        final UserEntity savedUser3 = userRepository.save(createDefaultUserEntity());
        savePlayerPermission(savedUser1.getId(), LOGIN_ID);
        savePlayerPermission(savedUser2.getId(), LOGIN_ID);
        savePlayerPermission(savedUser3.getId(), LOGIN_ID);

        final List<UserDto> playableUsersAfterSave = playerPermissionController.getPlayableUsers();
        assertEquals(4, playableUsersAfterSave.size());
        assertEquals(LOGIN_ID, playableUsersAfterSave.get(0).getId());
        assertEquals(savedUser1.getId(), playableUsersAfterSave.get(1).getId());
        assertEquals(savedUser2.getId(), playableUsersAfterSave.get(2).getId());
        assertEquals(savedUser3.getId(), playableUsersAfterSave.get(3).getId());
    }

    private void savePlayerPermission(final String userId, final String idToPermit){
        final PlayerPermissionEntity playerPermissionEntity = new PlayerPermissionEntity();
        playerPermissionEntity.setUserId(userId);
        playerPermissionEntity.setPermittedUserId(idToPermit);
        playerPermissionRepository.save(playerPermissionEntity);
    }
}