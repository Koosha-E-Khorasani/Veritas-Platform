package com.veritas.auth_service.application.outbound_port;

import com.veritas.auth_service.domain.user.Token;
import com.veritas.auth_service.domain.user.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(UUID id);
    List<User> findAll();
    List<User> findByRoleId(UUID roleId);
    List<User> findByPermissionId(UUID permissionId);
    Token getUserCurrentToken(UUID userId);
    void save(User user);
    void update(User user);
    void delete(User user);

}
