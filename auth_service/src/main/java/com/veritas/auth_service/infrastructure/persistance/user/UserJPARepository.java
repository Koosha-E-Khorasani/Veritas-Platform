package com.veritas.auth_service.infrastructure.persistance.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;


import java.util.UUID;


public interface UserJPARepository extends CrudRepository<UserJPAEntity,UUID>{
}
