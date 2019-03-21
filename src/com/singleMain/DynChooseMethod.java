package com.singleMain;

import java.lang.reflect.Method;

public class DynChooseMethod {
    public static void main(String[] args) throws Exception {
        //里面写自己的类名及路径
        //Class<?> c = Class.forName("com.singleMain.DynChooseMethod");
        String staticClassName = Thread.currentThread().getStackTrace()[1].getClassName();//用于静态类
        System.out.println(staticClassName);
        //String className = this.getClass().getName();//常用这种
        Class<?> c = Class.forName(staticClassName);
        Object obj = c.newInstance();
        //第一个参数写的是方法名,第二个\第三个\...写的是方法参数列表中参数的类型
        Method method = c.getMethod("bbb", String.class, int.class);
        //invoke是执行该方法,并携带参数值
        String result = (String) method.invoke(obj, new Object[]{"myname",3});
    }

    //动态调get set可以参考https://www.cnblogs.com/jason123/p/7092008.html

    public String aaa(String str){
        System.out.println("调用了aaa方法："+ str);
        return str;
    }

    public String bbb(String str,int i){
        System.out.println("调用了bbb方法："+ str);
        for(int j=0; j<i; j++){
            System.out.println(str+"22222");
        }
        return str;
    }
}
