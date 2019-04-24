package com.singleMain;

import com.commonEntity.StudentGrand;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Row2Line {
    public static void main(String[] args) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        //���ṩ�Ķ����б�
        List<StudentGrand> StudentGrandList = getStudentGrandList();
        //��Ҫ���㷨
        List<List<String>> convertedTable = convert(StudentGrandList);
        //��ӡ���
        print(convertedTable);
        //ʣ�µ����Լ����Ű�
    }

    private static List<List<String>> convert(List<StudentGrand> StudentGrandList)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        //��ֻ���ṩ˼·������������Լ������һ��
        //ȡ��StudentGrand�����ԣ���Ȼ��Ҳ������list = {"id", "name", ...}
        Field[] declaredFields = StudentGrand.class.getDeclaredFields();

        List<List<String>> convertedTable = new ArrayList<List<String>>();

        //���ٸ����Ա�ʾ�����У�������
        for (Field field : declaredFields) {
            field.setAccessible(true);//��Ϊtrue��field.get(obj)�ſ��Զ�˽�б�����Ч
            ArrayList<String> rowLine = new ArrayList<String>();
            //list<T>���ٸ�StudentGrandʵ�����ʾ�ж����У�������
            for (int i = 0, size = StudentGrandList.size() + 1; i < size; i++) {
                //ÿһ�еĵ�һ�ж�ӦStudentGrand�ֶ���
                //������table�ĵ�һ��Ҫ����Ϊ�ֶ���
                if(i == 0){
                    rowLine.add(field.getName());
                }
                //��table�ӵڶ��п�ʼ��ĳһ�е�ĳ��ֵ��Ӧ��table��һ�е�ĳ���ֶ�
                else{
                    StudentGrand StudentGrand = StudentGrandList.get(i - 1);
                    String attr_type = field.getType().toString();
                    if(attr_type.equalsIgnoreCase("int")){
                        int val = (int) field.get(StudentGrand);
                        System.out.println(val);
                        rowLine.add(val+"");//rowLine�����ֻ����һ������
                    }else{
                        String val = (String) field.get(StudentGrand);//grandΪint�ᱨ��
                        //System.out.println(val);
                        rowLine.add(val);
                    }
                }
            }
            convertedTable.add(rowLine);
        }
        return convertedTable;
    }

    private static List<StudentGrand> getStudentGrandList () {
        List<StudentGrand> list = new ArrayList<StudentGrand>();
        list.add(new StudentGrand("001", "toni", "����", 98));
        list.add(new StudentGrand("002", "toni", "��ѧ", 98));
        list.add(new StudentGrand("003", "toni", "����", 98));
        list.add(new StudentGrand("004", "toni", "����", 98));
        list.add(new StudentGrand("005", "amy", "����", 98));
        list.add(new StudentGrand("006", "amy", "��ѧ", 98));
        list.add(new StudentGrand("007", "amy", "����", 98));
        list.add(new StudentGrand("008", "amy", "����", 98));
        list.add(new StudentGrand("009", "������", "����", 98));
        list.add(new StudentGrand("010", "������", "��ѧ", 98));
        list.add(new StudentGrand("011", "������", "����", 98));
        list.add(new StudentGrand("012", "������", "����", 98));
        return list;
    }

    private static void print(List<List<String>> convertedTable) {
        //String json = JSONArray.formObject(convertedTable).toString();
        for (List<String> list : convertedTable) {
            for (String string : list) {
                System.out.print(string+"  ");
            }
            System.out.println();
        }
    }
}
