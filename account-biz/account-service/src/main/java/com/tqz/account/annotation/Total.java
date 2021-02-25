package com.tqz.account.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/24 9:24
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@One
@Two
public @interface Total {
}
