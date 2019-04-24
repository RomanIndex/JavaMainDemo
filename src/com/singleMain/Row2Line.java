package com.singleMain;

import com.commonEntity.StudentGrand;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Row2Line {
    public static void main(String[] args) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        //你提供的对象列表
        List<StudentGrand> StudentGrandList = getStudentGrandList();
        //你要的算法
        List<List<String>> convertedTable = convert(StudentGrandList);
        //打印结果
        print(convertedTable);
        //剩下的你自己看着办
    }

    private static List<List<String>> convert(List<StudentGrand> StudentGrandList)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        //我只是提供思路，具体代码你自己再设计一下
        //取得StudentGrand的属性，当然你也可以用list = {"id", "name", ...}
        Field[] declaredFields = StudentGrand.class.getDeclaredFields();

        List<List<String>> convertedTable = new ArrayList<List<String>>();

        //多少个属性表示多少行，遍历行
        for (Field field : declaredFields) {
            field.setAccessible(true);//设为true，field.get(obj)才可以对私有变量生效
            ArrayList<String> rowLine = new ArrayList<String>();
            //list<T>多少个StudentGrand实体类表示有多少列，遍历列
            for (int i = 0, size = StudentGrandList.size() + 1; i < size; i++) {
                //每一行的第一列对应StudentGrand字段名
                //所以新table的第一列要设置为字段名
                if(i == 0){
                    rowLine.add(field.getName());
                }
                //新table从第二列开始，某一列的某个值对应旧table第一列的某个字段
                else{
                    StudentGrand StudentGrand = StudentGrandList.get(i - 1);
                    String attr_type = field.getType().toString();
                    if(attr_type.equalsIgnoreCase("int")){
                        int val = (int) field.get(StudentGrand);
                        System.out.println(val);
                        rowLine.add(val+"");//rowLine定义的只能有一种类型
                    }else{
                        String val = (String) field.get(StudentGrand);//grand为int会报错
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
        list.add(new StudentGrand("001", "toni", "语文", 98));
        list.add(new StudentGrand("002", "toni", "数学", 98));
        list.add(new StudentGrand("003", "toni", "外语", 98));
        list.add(new StudentGrand("004", "toni", "体育", 98));
        list.add(new StudentGrand("005", "amy", "语文", 98));
        list.add(new StudentGrand("006", "amy", "数学", 98));
        list.add(new StudentGrand("007", "amy", "外语", 98));
        list.add(new StudentGrand("008", "amy", "体育", 98));
        list.add(new StudentGrand("009", "安东尼", "语文", 98));
        list.add(new StudentGrand("010", "安东尼", "数学", 98));
        list.add(new StudentGrand("011", "安东尼", "外语", 98));
        list.add(new StudentGrand("012", "安东尼", "体育", 98));
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
