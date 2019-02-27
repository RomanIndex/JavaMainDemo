package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ObjectUtils;

/**
 * 注解验证处理类
 * 
 * @author zhy
 * @date 2017/2/22
 */
public class AnnotationDetail {
	//private static Logger log = Logger.getAnonymousLogger();
 
	/**
	 * 注解验证电泳方法
	 * 
	 * @author zhy
	 * @param bean 验证的实体
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> validate(Object bean) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("message", "验证通过");
		result.put("result", true);
		Class<?> cls = bean.getClass();
		
		// 检测field是否存在
		try {
			// 获取实体字段集合
			Field[] fields = cls.getDeclaredFields();
			for (Field f : fields) {
				// 通过反射获取该属性对应的值
				f.setAccessible(true);
				// 获取字段值
				Object value = f.get(bean);
				// 获取字段上的注解集合
				Annotation[] arrayAno = f.getAnnotations();
				for (Annotation annotation : arrayAno) {
					// 获取注解类型（注解类的Class）
					Class<?> clazz = annotation.annotationType();
					// 获取注解类中的方法集合
					Method[] methodArray = clazz.getDeclaredMethods();
					for (Method method : methodArray) {
						// 获取方法名
						String methodName = method.getName();
						// 过滤错误提示方法的调用
						if(methodName.equals("message")) {
							continue;
						}
						// 初始化注解验证的方法处理类 （我的处理方法 写在 本类中）
						Object obj = AnnotationDetail.class.newInstance();
						// 获取方法
						try {
							// 根据方法名获取该方法（本类 中 定义的处理方法 要和 标签类 里面定义的 “同方法名”）
							Method m = obj.getClass().getDeclaredMethod(methodName, Object.class, Field.class);
							// 调用该方法
							result = (Map<String, Object>)m.invoke(obj, value, f);
							/* 验证结果 有一处失败则退出 */
							if(result.get("result").equals(false)) {
								return result;
							}
						} catch (Exception e) {
							e.printStackTrace();
							//log.info("找不到该方法:"+methodName);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			//log.info("验证出错");
		}
		return result;
	}
 
	/**
	 * 验证是否空值
	 * 
	 * @author zhy
	 * @param value 参数值
	 * @param field 字段
	 * @return
	 */
	public Map<String, Object> isEmpty(Object value, Field field) {
		Map<String, Object> validateResult = new HashMap<String, Object>();
		IsEmptyAnnotation annotation = field.getAnnotation(IsEmptyAnnotation.class);
		if(value == null || value.equals("")) {
			validateResult.put("message", field.getName() + annotation.message());
			validateResult.put("result", false);
		} else {
			validateResult.put("message", "验证通过");
			validateResult.put("result", true);
		}
		return validateResult;
	}
	
	/**
	 * 验证 最小字符长度
	 * 
	 * @author zhy
	 * @param value 参数值
	 * @param field 字段
	 * @return
	 */
	public Map<String, Object> min(Object value, Field field) {
		Map<String, Object> validateResult = new HashMap<String, Object>();
		MinSize annotation = field.getAnnotation(MinSize.class);
		if(value != null && value.toString().length() < annotation.min()) {
			validateResult.put("message", annotation.message());
			validateResult.put("result", false);
		} else {
			validateResult.put("message", "验证通过");
			validateResult.put("result", true);
		}
		return validateResult;
	}
	
	/**
	 * 验证 最大字符长度
	 * 
	 * @author zhy
	 * @param value 参数值
	 * @param field 字段
	 * @return
	 */
	public Map<String, Object> max(Object value, Field field) {
		Map<String, Object> validateResult = new HashMap<String, Object>();
		MaxSize annotation = field.getAnnotation(MaxSize.class);
		if(value != null && value.toString().length() > annotation.max()) {
			validateResult.put("message", annotation.message());
			validateResult.put("result", false);
		} else {
			validateResult.put("message", "验证通过");
			validateResult.put("result", true);
		}
		return validateResult;
	}
	
	/**
	 * 验证 电话号码格式
	 * 
	 * @author zhy
	 * @param value 参数值
	 * @param field 字段
	 * @return
	 */
	public Map<String, Object> mobile(Object value, Field field) {
		Map<String, Object> validateResult = new HashMap<String, Object>();
		Mobile annotation = field.getAnnotation(Mobile.class);//这个要改---
		
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,1,2,5-9])|(177))\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
		
        if(!ObjectUtils.equals(value, null)){
        	Matcher m = pattern.matcher(value.toString());
        	
        	if(!m.matches()) {
        		validateResult.put("message", annotation.message());
        		validateResult.put("result", false);
        	} else {
        		validateResult.put("message", "验证通过");
        		validateResult.put("result", true);
        	}
        }else{
        	validateResult.put("message", "电话为空，不校验，通过");
    		validateResult.put("result", true);
        }
		
        return validateResult;
	}
}