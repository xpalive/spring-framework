package com.xiongping.transacation;

import java.lang.annotation.*;

/**
 * @author xiongping
 * @version 1.0
 * @since 2024/9/13
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Activity {
	boolean value() default true;
}
