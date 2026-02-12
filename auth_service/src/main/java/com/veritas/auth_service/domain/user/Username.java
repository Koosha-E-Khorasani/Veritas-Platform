package com.veritas.auth_service.domain.user;

public record Username(String value) {
    public Username{
        if(value == null){
            throw new NullPointerException("value is null");
        }

    }
}
