package com.veritas.auth_service.domain.user;

public record UserPassword(String value) {
    private static final String SPECIAL_CHAR_REGEX = ".*[^a-zA-Z0-9].*";
    public UserPassword{
        if(!value.matches(SPECIAL_CHAR_REGEX)){
            throw new IllegalArgumentException("Invalid user password. Password should contain special characters!");
        }
        if(value.length() < 8) {
            throw new IllegalArgumentException("Password length should be at least 8 characters");
        }
    }

}
