package com.veritas.auth_service.domain.user;

import java.time.LocalDateTime;

public class Token {
    TokenId tokenId;
    LocalDateTime expiryDate;
    LocalDateTime createdDate;
    String hash;

}
