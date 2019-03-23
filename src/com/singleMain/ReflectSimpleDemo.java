package com.singleMain;

import com.commonEntity.StudentGrand;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReflectSimpleDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
        //ʹ�÷����һ��:��ȡ������FieldDemo����Ӧ��Class����
        Class<?> cls = Class.forName("com.commonEntity.StudentGrand");
        //Class<?> cls = Class.forName("zz.demo.entity.FieldDemo");
        System.out.println("cls:"+ cls);
        //ʹ��FieldDemo���class�������� ʵ��

        StudentGrand obj = new StudentGrand("hjhgjh", "zhangsanf", "english", 98, new Date(), 666);
        //Object obj = cls.newInstance();
        System.out.println("obj:"+ obj);
        System.out.println("obj.getClass():"+ obj.getClass());

        //ͨ��Class����getField(String name)�� ��ȡ���ض��ķ�����name����ָ�������Ե�����
        Field public_attr = cls.getField("type");
        //Field field = cls.getDeclaredField("id");
        Field field = obj.getClass().getDeclaredField("createTime");//���ָ��������
        field.setAccessible(true);//��Ϊtrue��field.get(obj)�ſ��Զ�˽�б�����Ч
        Field[] public_fields = cls.getFields();
        Field[] fields = cls.getDeclaredFields();

        //�õ���Field���ʵ����Ϳ��Ե������еķ�����

        //����:getModifiers()  ��������ʽ�����ɴ� Field �����ʾ���ֶε� Java �������η�
        System.out.println("���η�:  " + Modifier.toString(field.getModifiers()));

        //����:getType()  ����һ�� Class ��������ʶ�˴� Field ��������ʾ�ֶε���������
        System.out.println("����:  "+field.getType());
        System.out.println("��������:  "+ field.getType().toString());

        //����:get(Object obj) ����ָ������obj�ϴ� Field ��ʾ���ֶε�ֵ
        String attrName = field.getName();
        System.out.println("����ֵ:  "+ attrName);
        //תΪ����ĸ��д
        char[] cs=attrName.toCharArray();
        cs[0]-=32;
        String getVal = "set"  + String.valueOf(cs);
        System.out.println("getVal:"+getVal);
        //����: set(Object obj, Object value)  ��ָ����������ϴ� Field �����ʾ���ֶ�����Ϊָ������ֵ
        //field.set(obj, 666);//ò��ֻ������public������;field.setAccessible(true)����
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("�޸�����ֵ�� --> get(Object obj):  "+field.get(obj));
        System.out.println("�޸�����ֵ������ --> get(Object obj)Type:  "+sdf.format(field.get(obj)));
    }
}
