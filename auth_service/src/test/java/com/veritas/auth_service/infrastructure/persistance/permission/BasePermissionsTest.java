package com.veritas.auth_service.infrastructure.persistance.permission;

import com.veritas.auth_service.infrastructure.persistance.role.RoleJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.role.RoleJPARepository;
import com.veritas.auth_service.infrastructure.persistance.user.UserJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.user.UserJPARepository;
import com.veritas.auth_service.infrastructure.persistance.user_role.UserRoleID;
import com.veritas.auth_service.infrastructure.persistance.user_role.UserRoleJPAEntity;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@ActiveProfiles("test")
@Import(TestConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class BasePermissionsTest {

     public final int INITIAL_PERMISSIONS_NUMBER=4;
     public final String PERMISSION_NAME = "Permission Name";
     public final String PERMISSION_NAME2 = "Permission Name2";
    public final String PERMISSION_NAME3 = "Permission Name3";
    public final String PERMISSION_NAME4 = "Permission Name4";
     public final String ROLE_NAME = "Role Name";
     public final String ROLE_NAME2 = "Role Name2";
    public final String ROLE_NAME3 = "Role Name3";
     public final String USERNAME = "username";
     public final String USERNAME2 = "username2";
     public final String PASSWORD = "password";
     public final String PASSWORD2 = "password2";
     public final String EMAIL = "email";
     public final String EMAIL2 = "email2";

    @Autowired
    private RoleJPARepository roleJPARepository;

    @Autowired
    private UserJPARepository userJPARepository;

    @Autowired
    private PermissionJPARepository permissionJPARepository;

    /*
     Creating two users, first user with two roles, first role with one permission, second role with 2 permissions.
     The second user has a role and the role has a permission.
     */
    @BeforeEach
    public void set_initial_data(){
        PermissionJPAEntity testPermission = createPermissionJPAEntity(PERMISSION_NAME);
        PermissionJPAEntity testPermission2 = createPermissionJPAEntity(PERMISSION_NAME2);
        PermissionJPAEntity testPermission3 = createPermissionJPAEntity(PERMISSION_NAME3);
        UserJPAEntity userJPAEntity = createUserJPAEntity(USERNAME,PASSWORD,EMAIL);
        RoleJPAEntity userFirstRole = createRoleJPAEntity(testPermission,ROLE_NAME);
        List<PermissionJPAEntity> permissionJPAEntitiesForSecondRole = new ArrayList<>();
        permissionJPAEntitiesForSecondRole.add(testPermission2);
        permissionJPAEntitiesForSecondRole.add(testPermission3);
        RoleJPAEntity userSecondRole = createRoleJPAEntity(permissionJPAEntitiesForSecondRole,ROLE_NAME2);
        UserRoleJPAEntity userRoleJPAEntity = createUserRoleJPAEntity(userJPAEntity, userFirstRole);
        UserRoleJPAEntity userRoleJPAEntity2 = createUserRoleJPAEntity(userJPAEntity, userSecondRole);
        userJPAEntity.addRole(userRoleJPAEntity);
        userJPAEntity.addRole(userRoleJPAEntity2);
        userJPARepository.save(userJPAEntity);
        roleJPARepository.save(userFirstRole);
        roleJPARepository.save(userSecondRole);

        PermissionJPAEntity testPermission4 = createPermissionJPAEntity(PERMISSION_NAME4);
        UserJPAEntity userJPAEntity2 = createUserJPAEntity(USERNAME2,PASSWORD2,EMAIL2);
        RoleJPAEntity roleJPAEntity3 = createRoleJPAEntity(testPermission4,ROLE_NAME3);
        UserRoleJPAEntity userRoleJPAEntity3 = createUserRoleJPAEntity(userJPAEntity, roleJPAEntity3);
        userJPAEntity.addRole(userRoleJPAEntity3);
        userJPARepository.save(userJPAEntity2);
        roleJPARepository.save(roleJPAEntity3);


    }

    private UserJPAEntity createUserJPAEntity(String username, String password, String email) {
        UserJPAEntity userJPAEntity = new UserJPAEntity();
        userJPAEntity.setUsername(username);
        userJPAEntity.setPassword(password);
        userJPAEntity.setEmail(email);
        userJPAEntity.setVerified(true);
        userJPAEntity.setCreated(LocalDateTime.now());
        userJPAEntity.setUpdated(LocalDateTime.now());
        userJPAEntity.setLastLogin(LocalDateTime.now());
        return userJPAEntity;
    }

    private RoleJPAEntity createRoleJPAEntity(PermissionJPAEntity permission,String roleName) {
        RoleJPAEntity roleJPAEntity = new RoleJPAEntity();
        roleJPAEntity.addPermission(permission);
        roleJPAEntity.setName(roleName);
        return roleJPAEntity;
    }

    private RoleJPAEntity createRoleJPAEntity(List<PermissionJPAEntity> permissions, String roleName) {
        RoleJPAEntity roleJPAEntity = new RoleJPAEntity();
        permissions.stream().forEach(permission -> roleJPAEntity.addPermission(permission));
        roleJPAEntity.setName(roleName);
        return roleJPAEntity;
    }

    private PermissionJPAEntity createPermissionJPAEntity(String permissionName) {
        PermissionJPAEntity permissionJPAEntity = new PermissionJPAEntity();
        permissionJPAEntity.setName(permissionName);
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
