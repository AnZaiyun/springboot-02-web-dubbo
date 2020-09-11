package com.anzaiyun.api.conf;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChineseNamesAnno {

    public String ChineseName() default "无";
}
