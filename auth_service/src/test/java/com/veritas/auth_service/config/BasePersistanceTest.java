package com.veritas.auth_service.config;

import com.veritas.auth_service.infrastructure.persistance.permission.PermissionJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.permission.PermissionJPARepository;
import com.veritas.auth_service.infrastructure.persistance.role.RoleJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.role.RoleJPARepository;
import com.veritas.auth_service.infrastructure.persistance.user.UserJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.user.UserJPARepository;
import com.veritas.auth_service.infrastructure.persistance.user_role.UserRoleID;
import com.veritas.auth_service.infrastructure.persistance.user_role.UserRoleJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.user_role.UserRoleJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;


@DataJpaTest
@ActiveProfiles("test")
@Import(TestConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class BasePersistanceTest {

    @Autowired
    private RoleJPARepository roleJPARepository;

    @Autowired
    private UserJPARepository userJPARepository;

    @Autowired
    private PermissionJPARepository permissionJPARepository;

    @BeforeEach
    public void set_initial_data(){
        PermissionJPAEntity permissionJPAEntity = createPermissionJPAEntity();
        UserJPAEntity userJPAEntity = createUserJPAEntity();
        RoleJPAEntity roleJPAEntity = createRoleJPAEntity(permissionJPAEntity);
        UserRoleJPAEntity userRoleJPAEntity = createUserRoleJPAEntity(userJPAEntity, roleJPAEntity);
        userJPAEntity.addRole(userRoleJPAEntity);

        userJPARepository.save(userJPAEntity);
        roleJPARepository.save(roleJPAEntity);

    }

    private UserJPAEntity createUserJPAEntity() {
        UserJPAEntity userJPAEntity = new UserJPAEntity();
        userJPAEntity.setUsername("testUsername");
        userJPAEntity.setPassword("password");
        userJPAEntity.setEmail("testEmail@g.com");
        userJPAEntity.setVerified(true);
        userJPAEntity.setCreated(LocalDateTime.now());
        userJPAEntity.setUpdated(LocalDateTime.now());
        userJPAEntity.setLastLogin(LocalDateTime.now());

        userJPAEntity.setVerified(true);
        return userJPAEntity;
    }

    private RoleJPAEntity createRoleJPAEntity(PermissionJPAEntity permission) {
        RoleJPAEntity roleJPAEntity = new RoleJPAEntity();
        roleJPAEntity.addPermission(permission);
        roleJPAEntity.setName("testRole");
        return roleJPAEntity;
    }

    private PermissionJPAEntity createPermissionJPAEntity() {
        PermissionJPAEntity permissionJPAEntity = new PermissionJPAEntity();
        permissionJPAEntity.setName("testPermission");
        return permissionJPAEntity;
    }

    private UserRoleJPAEntity createUserRoleJPAEntity(UserJPAEntity userJPAEntity,RoleJPAEntity roleJPAEntity) {
        UserRoleJPAEntity userRoleJPAEntity = new UserRoleJPAEntity();
        userRoleJPAEntity.setId(new UserRoleID(userJPAEntity.getId(),roleJPAEntity.getRoleId()));
        userRoleJPAEntity.setUserJPAEntity(userJPAEntity);
        userRoleJPAEntity.setRoleJPAEntity(roleJPAEntity);
        return userRoleJPAEntity;
    }






}
