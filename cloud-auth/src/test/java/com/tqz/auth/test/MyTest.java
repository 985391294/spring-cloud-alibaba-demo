package com.tqz.auth.test;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>
 *
 * @author tianqingzhao
 * @since 2021/4/8 14:29
 */
@SpringBootTest
public class MyTest {

    @Test
    public void test1() {
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassWord = "$2a$10$gExKdT3nkoFKfW1cFlqQUuFji3azHG.W4Pe3/WxHKANg3TpkSJRfW";
        boolean f = bcryptPasswordEncoder.matches("111111", encodePassWord);
        System.out.println(f);

    }
}
