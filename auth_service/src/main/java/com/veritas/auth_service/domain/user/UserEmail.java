package com.veritas.auth_service.domain.user;

public record UserEmail(String value) {
    private static String EMAIL_PATTERN="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public UserEmail{
        if (!value.matches(EMAIL_PATTERN)) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }
}
