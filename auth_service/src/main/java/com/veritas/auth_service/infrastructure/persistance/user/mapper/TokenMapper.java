package com.veritas.auth_service.infrastructure.persistance.user.mapper;

import com.veritas.auth_service.domain.user.Token;
import com.veritas.auth_service.domain.user.TokenId;
import com.veritas.auth_service.infrastructure.persistance.user.TokenJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.user.UserJPAEntity;


import java.util.List;
import java.util.Map;

public class TokenMapper {
    public static Token toDomainObject(TokenJPAEntity tokenJPAEntity){
        return new Token(new TokenId(tokenJPAEntity.getId()),tokenJPAEntity.getExpiryDate(),tokenJPAEntity.getCreatedDate(),tokenJPAEntity.getHash());
    }

    public static TokenJPAEntity toJPAEntity(Token token, UserJPAEntity owner){
        TokenJPAEntity tokenJPAEntity = new TokenJPAEntity();
        tokenJPAEntity.setId(token.getTokenId().id());
        tokenJPAEntity.setExpiryDate(token.getExpiryDate());
        tokenJPAEntity.setCreatedDate(token.getCreatedDate());
        tokenJPAEntity.setHash(token.getHash());
        return tokenJPAEntity;
    }

    public static List<TokenJPAEntity> toJPAEntities(List<Token> tokens,Map<Token, UserJPAEntity> tokenUserMap){
         return tokens.stream().map(token->toJPAEntity(token,tokenUserMap.get(token))).toList();
    }

    public static List<Token> toDomainObjects(List<TokenJPAEntity> tokenJPAEntities){
        return tokenJPAEntities.stream().map(jpaEntity->toDomainObject(jpaEntity)).toList();
    }
}
