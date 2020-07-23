package com.skr.im.access.anno;

import com.skr.im.access.enumz.UserActionEnum;
import reactor.spring.annotation.SelectorType;

import java.lang.annotation.*;

/**
 * @author mqw
 * @create 2020-07-23-15:36
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface IMSelector {

    UserActionEnum value() default UserActionEnum.CHAT_PRIVATE;

    String reactor() default "reactor";

    SelectorType type() default SelectorType.OBJECT;
}
