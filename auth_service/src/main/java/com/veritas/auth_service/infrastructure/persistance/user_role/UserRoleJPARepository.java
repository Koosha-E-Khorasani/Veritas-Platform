package com.veritas.auth_service.infrastructure.persistance.user_role;

import org.springframework.data.repository.CrudRepository;

public interface UserRoleJPARepository extends CrudRepository<UserRoleJPAEntity,UserRoleID> {
}
