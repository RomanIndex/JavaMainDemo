package com.singleMain;

import com.commonEntity.Student;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;

public class DynChooseGetSet {

    /**
     * 详细还有待研究，以下不保证一定正确2019-03-06
     */
    public static void main(String[] args) throws Exception {
        Student student = new Student();
        student.setId("st00001");
        student.setName("眦睚");
        student.setAge(26);
        student.setCreateTime(Calendar.getInstance().getTime());
        getProperty(student, "id");
        //setProperty(student, "name", "必报！");
        //setAllProperty(student, "统一String！！");//类型不是string会出错，
        //getAllProperty(student);
        //System.out.println("后的值："+ student.getName());
    }

    public static void getProperty(Object obj, String propertyName) throws Exception {
        //Class clazz = Class.forName("com.itcast.day26.Person");
        Class clazz = obj.getClass();

        //Field field = clazz.getDeclaredField("name");
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, clazz);
        Method get = pd.getReadMethod();
        String name = (String)get.invoke(obj);
        System.out.println(name);
    }

    /* 该方法用于传入某实例对象以及对象方法名，通过反射调用该对象的某个get方法 */
    public static void getAllProperty(Object beanObj){
        try {
            Field[] fields = beanObj.getClass().getDeclaredFields();//获得属性
            Class clazz = beanObj.getClass();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                // 此处应该判断beanObj,property不为null
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                if (getMethod != null) {
                    System.out.println(beanObj+"的字段是:"+field.getName()+"，类型是："+field.getType()+"，取到的值是： "+getMethod.invoke(beanObj));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

    public static void setProperty(Object obj, String propertyName, Object value){
        Class clazz = obj.getClass();//获取对象类型
        try {
            PropertyDescriptor pd = getPropertyDescriptor(clazz, propertyName);//获取 clazz 类型中的 propertyName 的属性描述器
            Method setMethod = pd.getWriteMethod();//从属性描述器中获取set方法
            setMethod.invoke(obj, new Object[]{value});
            //setMethod.invoke(obj, value);//invoke是执行set方法
        }catch (Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static PropertyDescriptor getPropertyDescriptor(Class clazz, String propertyName) {
        //StringBuffer不存在继承关系，无法进行强转,StringBuffer类中的方法主要偏重于对于字符串的变化，和String类的主要区别它仅一次开辟了内存空间
        StringBuffer sb = new StringBuffer();//构建一个可变字符串用来构建方法名称
        Method setMethod = null;
        Method getMethod = null;
        PropertyDescriptor propertyDescriptor = null;
        try {
            Field f = clazz.getDeclaredField(propertyName);
            if (f != null) {
                //获取把方法名首字母改成大写
                String methodSuffix = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                //构建的set方法
                sb.append("set" + methodSuffix);
                setMethod = clazz.getDeclaredMethod(sb.toString(), new Class[]{f.getType()});
                sb.delete(0, sb.length());//清空整个可变字符串
                sb.append("get" + methodSuffix);
                getMethod = clazz.getDeclaredMethod(sb.toString(), new Class[]{});
                //构建一个属性描述器 把对应属性 propertyName 的 get 和 set 方法保存到属性描述器中
                propertyDescriptor = new PropertyDescriptor(propertyName, getMethod, setMethod);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return propertyDescriptor;
    }

    /* 该方法用于传入某实例对象以及对象方法名、修改值，通过放射调用该对象的某个set方法设置修改值 */
    public static void setAllProperty(Object beanObj, Object value){
        try {
            Field[] fields = beanObj.getClass().getDeclaredFields();//获得属性
            Class clazz = beanObj.getClass();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                // 此处应该判断beanObj,property不为null
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), beanObj.getClass());
                Method setMethod = pd.getWriteMethod();
                if (setMethod != null) {
                    System.out.println(beanObj+"的字段是:"+field.getName()+"，参数类型是："+field.getType()+"，set的值是： "+value);
                    //这里注意实体类中set方法中的参数类型，如果不是String类型则进行相对应的转换
                    setMethod.invoke(beanObj, value);//invoke是执行set方法
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

}
