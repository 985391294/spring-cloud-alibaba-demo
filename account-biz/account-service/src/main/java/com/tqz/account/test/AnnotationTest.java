package com.tqz.account.test;

import com.tqz.account.annotation.One;
import com.tqz.account.annotation.Total;

/**
 * <p>
 *
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/24 9:24
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Class<User> userClass = User.class;
        if (userClass.getAnnotation(Total.class) != null) {
            new User();
        }
    }
}
