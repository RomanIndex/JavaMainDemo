package com.singleMain;

import com.commonEntity.Student;

import java.util.ArrayList;

public class JudgeParamType {
    public static void main(String[] args) {
        //Date param = new Date();
        //String param = "";//null����ָ���쳣
        //List<OneWeekAttr> param = new ArrayList<>();
        //OneWeekAttr param = new OneWeekAttr();
        Student param = new Student();
        syso(param);
    }

    private static <T> void syso(T param) {
        if(param instanceof String){
            System.out.println("��string");
        }else if (param instanceof Student) {
            System.out.println("��Student");
        }else if (param instanceof ArrayList) {
            System.out.println("��ArrayList");
        }else if (param instanceof Object) {
            System.out.println("��object");
        }else{
            String type = param.getClass().getName();
            System.out.println(type);
        }

    }
}
