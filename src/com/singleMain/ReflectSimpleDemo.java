package com.singleMain;

import com.commonEntity.StudentGrand;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReflectSimpleDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
        //使用反射第一步:获取操作类FieldDemo所对应的Class对象
        Class<?> cls = Class.forName("com.commonEntity.StudentGrand");
        //Class<?> cls = Class.forName("zz.demo.entity.FieldDemo");
        System.out.println("cls:"+ cls);
        //使用FieldDemo类的class对象生成 实例

        StudentGrand obj = new StudentGrand("hjhgjh", "zhangsanf", "english", 98, new Date(), 666);
        //Object obj = cls.newInstance();
        System.out.println("obj:"+ obj);
        System.out.println("obj.getClass():"+ obj.getClass());

        //通过Class类中getField(String name)： 获取类特定的方法，name参数指定了属性的名称
        Field public_attr = cls.getField("type");
        //Field field = cls.getDeclaredField("id");
        Field field = obj.getClass().getDeclaredField("createTime");//这种更易于理解
        field.setAccessible(true);//设为true，field.get(obj)才可以对私有变量生效
        Field[] public_fields = cls.getFields();
        Field[] fields = cls.getDeclaredFields();

        //拿到了Field类的实例后就可以调用其中的方法了

        //方法:getModifiers()  以整数形式返回由此 Field 对象表示的字段的 Java 语言修饰符
        System.out.println("修饰符:  " + Modifier.toString(field.getModifiers()));

        //方法:getType()  返回一个 Class 对象，它标识了此 Field 对象所表示字段的声明类型
        System.out.println("类型:  "+field.getType());
        System.out.println("类型类型:  "+ field.getType().toString());

        //方法:get(Object obj) 返回指定对象obj上此 Field 表示的字段的值
        String attrName = field.getName();
        System.out.println("属性值:  "+ attrName);
        //转为首字母大写
        char[] cs=attrName.toCharArray();
        cs[0]-=32;
        String getVal = "set"  + String.valueOf(cs);
        System.out.println("getVal:"+getVal);
        //方法: set(Object obj, Object value)  将指定对象变量上此 Field 对象表示的字段设置为指定的新值
        //field.set(obj, 666);//貌似只能用于public的属性;field.setAccessible(true)即可
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("修改属性值后 --> get(Object obj):  "+field.get(obj));
        System.out.println("修改属性值的类型 --> get(Object obj)Type:  "+sdf.format(field.get(obj)));
    }
}
