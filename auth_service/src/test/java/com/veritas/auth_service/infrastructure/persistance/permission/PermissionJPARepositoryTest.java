package com.veritas.auth_service.infrastructure.persistance.permission;

import com.veritas.auth_service.config.BasePersistanceTest;
import com.veritas.auth_service.infrastructure.persistance.role.RoleJPARepository;
import com.veritas.auth_service.infrastructure.persistance.role.RoleRepositoryImpl;
import com.veritas.auth_service.infrastructure.persistance.user.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

public class PermissionJPARepositoryTest extends BasePersistanceTest {

}
