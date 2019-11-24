package com.idanchuang.shop.user.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.idanchuang.shop.user.sys.entity.Users;
import org.springframework.beans.factory.annotation.Value;

public class Token {

    public static Users user;

    private static final String secret = "od2l71FurmgByTtMKODaGI9iH3NLf5zcUqEepvkS4XnjhC8PAVxbRWZws6JQY0Qt";

    /**
     * 根据用户获取一个token
     */
    public static String getToken(Users user) {
        return JWT.create().withClaim("userId", user.getId())
                .sign(Algorithm.HMAC256(secret));
    }

    public static DecodedJWT verify(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .build();
        return verifier.verify(token);
    }
}
