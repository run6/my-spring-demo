package com.idanchuang.shop.user;

import com.idanchuang.shop.user.utils.BCrypt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class CryptTests {
    @Test
    void cryptTests() {

        var pwd = "123456";
        // 如果使用 BCrypt 这里的$2y$ 是不太行的.需要自行替换成$2a$
        var hasPwd = "$2y$10$qaZXIqWj6SQeq4/T8NgTOe8ga9hb12Zepgnw3HZM83JbeidOOlWDy";

        // 正则替换 将开头的 $2y$ 替换成 $2a$
        String pattern = "^\\$2y\\$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(hasPwd);
        hasPwd = m.replaceFirst("\\$2a\\$");
        System.out.println(hasPwd); // $2y$10$qaZXIqWj6SQeq4/T8NgTOe8ga9hb12Zepgnw3HZM83JbeidOOlWDy
        System.out.println(BCrypt.checkpw(pwd, hasPwd));

        var bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.matches(pwd, hasPwd));

    }
}
