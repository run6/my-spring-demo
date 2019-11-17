package com.idanchuang.shop.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.idanchuang.shop.user.config.JWTConfig;
import com.idanchuang.shop.user.sys.entity.Users;
import com.idanchuang.shop.user.sys.mapper.UsersMapper;
import com.idanchuang.shop.user.sys.service.IUsersService;
import com.idanchuang.shop.user.utils.Token;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class JWTTest {


    @Autowired
    JWTConfig jwtConfig;

    @Test
    void jwtTest() {
        System.out.println(jwtConfig.getSecret());
//        var token = JWT.create().withClaim("userId", 1)
//                .withAudience("123")
//                .sign(Algorithm.HMAC256(code));
//
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(code))
//                .build(); //Reusable verifier instance
//
//        var userId = JWT.decode(token).getAudience().get(0);
//        System.out.println(userId);
//        DecodedJWT jwt = verifier.verify(token);
//        userId = jwt.getAudience().get(0);
//        System.out.println(userId);
    }
}
