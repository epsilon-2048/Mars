package com.mars.core.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MarsDataCheck {
    /**
     * 是否可为空
     * @return
     */
    boolean notNull() default false;

    /**
     * 是否是数字
     * @return
     */
    boolean number() default false;

    /**
     * 最大长度
     * @return
     */
    long length() default Long.MAX_VALUE;

    /**
     * 正则
     * @return
     */
    String reg() default "";

    /**
     * 提示语
     * @return
     */
    String msg() default "请填写正确的数据";
}
