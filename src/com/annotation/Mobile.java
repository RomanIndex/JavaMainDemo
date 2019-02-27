package com.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 电话号码 验证类
 * 
 * @author zhy
 * @date 2017/2/22
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mobile {
	public String mobile() default "";//看公共处理类逻辑，要定义一个方法，同 公共处理类 定义的处理方法同名
 
	public String message() default "格式不对";
}