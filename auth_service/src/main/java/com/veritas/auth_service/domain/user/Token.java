package com.veritas.auth_service.domain.user;

import java.time.LocalDateTime;

public class Token {
    TokenId tokenId;
    LocalDateTime expiryDate;
    LocalDateTime createdDate;
    String hash;

    public Token(TokenId tokenId, LocalDateTime expiryDate, LocalDateTime createdDate, String hash) {
        this.tokenId = tokenId;
        this.expiryDate = expiryDate;
        this.createdDate = createdDate;
        this.hash = hash;
    }

    public TokenId getTokenId() {
        return tokenId;
    }

    public void setTokenId(TokenId tokenId) {
        this.tokenId = tokenId;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
