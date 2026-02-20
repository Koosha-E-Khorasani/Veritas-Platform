package com.veritas.auth_service.domain.user;

import com.veritas.auth_service.domain.role.RoleId;

import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    UserId  id;

    Username username;
    UserPassword password;
    UserEmail email;
    boolean isVerified;
    LocalDateTime lastLogin;
    LocalDateTime creationDate;
    LocalDateTime updateDate;
    List<RoleId> roleId;
    List<TokenId> tokenIds;
    public UserId getId() {
        return id;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public List<TokenId> getTokenIds() {
        return tokenIds;
    }

    public void setTokenIds(List<TokenId> tokenIds) {
        this.tokenIds = tokenIds;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public UserPassword getPassword() {
        return password;
    }

    public void setPassword(UserPassword password) {
        this.password = password;
    }

    public UserEmail getEmail() {
        return email;
    }

    public void setEmail(UserEmail email) {
        this.email = email;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public List<RoleId> getRoleId() {
        return roleId;
    }

    public void setRoleId(List<RoleId> roleId) {
        this.roleId = roleId;
    }
    public void addRoleId(RoleId roleId) {
        this.roleId.add(roleId);
    }
}
