package com.veritas.auth_service.infrastructure.persistance.user.mapper;

import com.veritas.auth_service.domain.role.RoleId;
import com.veritas.auth_service.domain.user.*;
import com.veritas.auth_service.infrastructure.persistance.user.TokenJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.user.UserJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.user_role.UserRoleJPAEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserMapper {
    public static User toDomainObject(UserJPAEntity userJPAEntity, Set<TokenJPAEntity> tokenJPAEntitySet) {
        return new User(new UserId(userJPAEntity.getId()),new Username(userJPAEntity.getUsername()),new UserPassword(userJPAEntity.getPassword()),
                new UserEmail(userJPAEntity.getEmail()),userJPAEntity.isVerified(),
                userJPAEntity.getLastLogin(),userJPAEntity.getCreated(),
                userJPAEntity.getUpdated(),
                userJPAEntity.getRoles().stream().map(userRole->new RoleId(userRole.getId().roleId())).toList(),
                tokenJPAEntitySet.stream().map(token->new TokenId(token.getId())).toList());
    }

    public static UserJPAEntity toJPAEntity(User user, Set<UserRoleJPAEntity> userRoleJPAEntitySet) {
        UserJPAEntity userJPAEntity = new UserJPAEntity();
        userJPAEntity.setId(user.getId().id());
        userJPAEntity.setEmail(user.getEmail().value());
        userJPAEntity.setPassword(user.getPassword().value());
        userJPAEntity.setUsername(user.getUsername().value());
        userJPAEntity.setCreated(user.getCreationDate());
        userJPAEntity.setLastLogin(user.getLastLogin());
        userJPAEntity.setUpdated(user.getUpdateDate());
        userJPAEntity.setRoles(userRoleJPAEntitySet);
        return userJPAEntity;
    }

    public static List<UserJPAEntity> toJPAEntites(List<User> users, Map<User,Set<UserRoleJPAEntity>>  userRoleMap ) {
        return users.stream().map(user-> toJPAEntity(user,userRoleMap.get(user))).toList();
    }

    public static List<User> toDomainObjects(List<UserJPAEntity> users, Map<User,Set<TokenJPAEntity>>  userTokenMap ) {
        return users.stream().map(user->toDomainObject(user,userTokenMap.get(user))).toList();
    }

}
