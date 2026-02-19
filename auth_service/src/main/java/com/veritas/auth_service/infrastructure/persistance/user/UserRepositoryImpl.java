package com.veritas.auth_service.infrastructure.persistance.user;

import com.veritas.auth_service.application.outbound_port.UserRepository;
import com.veritas.auth_service.domain.user.Token;
import com.veritas.auth_service.domain.user.User;

import java.util.List;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(UUID id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public List<User> findByRoleId(UUID roleId) {
        return List.of();
    }

    @Override
    public List<User> findByPermissionId(UUID permissionId) {
        return List.of();
    }

    @Override
    public Token getUserCurrentToken(UUID userId) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
