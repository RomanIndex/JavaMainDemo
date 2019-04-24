package com.Java8Try;

import com.commonEntity.StudentGrand;

import java.util.*;

public class for2map {
    public static void main(String[] args) {

        String country = "�й�";

        List<String> special = new ArrayList<>();
        special.add("kongfu");
        special.add("�ƺ�¥");
        special.add("��ʼ��");

        List<StudentGrand> listMember = new ArrayList<>();
        StudentGrand zhangsan = new StudentGrand("1", "����", "����", 23, new Date(), 2000);
        StudentGrand lisi = new StudentGrand("2", "����", "Ӣ��", 23, new Date(), 2000);
        listMember.add(zhangsan);
        listMember.add(lisi);


        Map<String, Object> map = new HashMap<>();

        map.put("country", country);
        map.put("spec", special);
        map.put("memb", listMember);

        /**
         * �������Ҫ��(keys)��ֵ(values)ʹ�÷�������
         * �����ʹ�õ����԰汾����java 5�����Ǵ����ڱ���ʱɾ��entries������ʹ�÷�������
         * ����ʹ�÷���һ(��ֵ��Ҫ)��
         */

        System.out.println("----����������-------����map�еļ���-------------------");
        for (String key : map.keySet()) {

            System.out.println("Key = " + key);

        }
        System.out.println("---������������----------����map�е�ֵ��---------------------");
        for (Object value : map.values()) {

            System.out.println("Value = " + value);

        }
        System.out.println("---һһһһһһһ-------�����һ�ֱ���������--------------");
        for (Map.Entry<String, Object> entry : map.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }
        System.out.println("--------ʹ�÷��ͣ�-----------------------");

        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry<String, Object> entry = entries.next();

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }
        /**
         * ���ַ�ʽ����������ȴ�����ŵ����ڡ����ȣ����ϰ汾java������Ωһ����map�ķ�ʽ��
         * ��һ���ô��ǣ�������ڱ���ʱ����iterator.remove()��ɾ��entries���������������ܡ�
         * ����javadoc��˵���������for-each�����г���ʹ�ô˷���������ǲ���Ԥ��ġ�
         */
        System.out.println("--------��ʹ�÷��ͣ����ŵ����ڣ�-----------------");

        Iterator entries1 = map.entrySet().iterator();

        while (entries1.hasNext()) {

            Map.Entry entry = (Map.Entry) entries1.next();

            String key = (String)entry.getKey();//��ǿ������ת����

            Object value = entry.getValue();

            System.out.println("Key = " + key + ", Value = " + value);

        }
        System.out.println("-----�����ο�--------ͨ������ֵ��Ч�ʵͣ���ԭ��-------------------");

        for (String key : map.keySet()) {

            Object value = map.get(key);

            System.out.println("Key = " + key + ", Value = " + value);

        }

    }
}
