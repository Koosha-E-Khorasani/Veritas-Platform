package com.veritas.auth_service.infrastructure.persistance.permission;

import com.veritas.auth_service.application.outbound_port.PermissionRepository;
import com.veritas.auth_service.config.BasePersistanceTest;
import com.veritas.auth_service.infrastructure.persistance.permission.mapper.PermissionMapper;
import com.veritas.auth_service.infrastructure.persistance.role.RoleRepositoryImpl;
import com.veritas.auth_service.infrastructure.persistance.user.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;


public class PermissionRepositoryImplTest extends BasePersistanceTest {

    @Autowired
    private PermissionRepositoryImpl permissionRepository;


}
