package com.Java8Try;

import com.commonEntity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8_StreamIsBlank {
    public static void main(String[] args) {
        //List<Integer> integerList = Arrays.asList(12, 4, 100, 0, 35);
        List<Integer> integerList = Arrays.asList();
        int limitSum = integerList.stream().skip(4).limit(2).mapToInt(i -> i).sum();
        System.out.println("截取的部分和limitSum："+ limitSum);

        List<Student> students = new ArrayList<>();
        int ageSum = students.stream().mapToInt(each -> each.getAge()).sum();
        System.out.println("年龄和是ageSum："+ ageSum);
    }
}
