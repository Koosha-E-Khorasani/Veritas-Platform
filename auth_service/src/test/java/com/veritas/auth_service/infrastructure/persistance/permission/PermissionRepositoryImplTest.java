package com.veritas.auth_service.infrastructure.persistance.permission;

import com.veritas.auth_service.domain.permission.Permission;
import com.veritas.auth_service.infrastructure.persistance.role.RoleJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.role.RoleJPARepository;
import com.veritas.auth_service.infrastructure.persistance.user.UserJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.user.UserJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class PermissionRepositoryImplTest extends BasePermissionsTest {

    private final String NEW_PERMISSION="NEW_PERMISSION";
    @Autowired
    private PermissionRepositoryImpl permissionRepositoryImpl;
    @Autowired
    private RoleJPARepository roleJPARepository;
    @Autowired
    private PermissionJPARepository permissionJPARepository;
    @Autowired
    private UserJPARepository userJPARepository;

    @Test
     void shouldFindAllPermissions() {
        List<Permission> permissions = permissionRepositoryImpl.findAll();
        assertEquals(INITIAL_PERMISSIONS_NUMBER, permissions.size());
        assertEquals(PERMISSION_NAME,permissions.get(0).getName());
    }

    @Test
     void shouldFindPermissionById() {
        List<Permission> permissions = permissionRepositoryImpl.findAll();
        assertEquals(INITIAL_PERMISSIONS_NUMBER, permissions.size());
        Permission expectedPermission = permissions.get(0);
        Permission actualPermission = permissionRepositoryImpl.findPermissionById(expectedPermission.getPermissionId().id());
        assertEquals(expectedPermission.getPermissionId().id(),actualPermission.getPermissionId().id());
        assertEquals(expectedPermission.getName(),actualPermission.getName());
    }

    @Test
    void shouldFindPermissionsByRoleId(){
        RoleJPAEntity roleJPAEntity= roleJPARepository.getByName(ROLE_NAME2);
        List<Permission> permissions = permissionRepositoryImpl.findByRoleId(roleJPAEntity.getRoleId());
        assertEquals(2, permissions.size());
        assertEquals(PERMISSION_NAME2,permissions.get(0).getName());
        assertEquals(PERMISSION_NAME3,permissions.get(1).getName());
    }

    @Test
    void shouldFindPermissionsByUserId(){
        UserJPAEntity userJPAEntity = userJPARepository.findByEmail(EMAIL);
        List<Permission> permissions = permissionRepositoryImpl.findByUserID(userJPAEntity.getId());
        assertEquals(3, permissions.size());
        assertEquals(PERMISSION_NAME,permissions.get(0).getName());
        assertEquals(PERMISSION_NAME2,permissions.get(1).getName());
        assertEquals(PERMISSION_NAME3,permissions.get(2).getName());
    }

    @Test
    void shouldSavePermission() {
        permissionRepositoryImpl.save(generateTestPermission());
        assertTrue(permissionJPARepository.findByName(NEW_PERMISSION).isPresent());
    }

    @Test
    void shouldDeletePermission() {
        PermissionJPAEntity permissionJPAEntity = permissionJPARepository.findByName(PERMISSION_NAME3).get();
        permissionRepositoryImpl.delete(permissionJPAEntity.getId());
        assertFalse(permissionJPARepository.findByName(PERMISSION_NAME3).isPresent());
    }

    @Test
    void shouldUpdatePermission() {
        PermissionJPAEntity permissionJPAEntity = permissionJPARepository.findByName(PERMISSION_NAME3).get();
        permissionJPAEntity.setName(NEW_PERMISSION);
        permissionJPARepository.save(permissionJPAEntity);
        assertTrue(permissionJPARepository.findByName(NEW_PERMISSION).isPresent());
    }

    private Permission generateTestPermission(){
        Permission  permissionJPAEntity = new Permission(NEW_PERMISSION);
        return permissionJPAEntity;
    }

}
