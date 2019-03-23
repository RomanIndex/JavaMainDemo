package com.Java8Try;

import com.commonEntity.StudentGrand;

import java.util.*;

public class for2map {
    public static void main(String[] args) {

        String country = "中国";

        List<String> special = new ArrayList<>();
        special.add("kongfu");
        special.add("黄鹤楼");
        special.add("秦始皇");

        List<StudentGrand> listMember = new ArrayList<>();
        StudentGrand zhangsan = new StudentGrand("1", "张三", "语文", 23, new Date(), 2000);
        StudentGrand lisi = new StudentGrand("2", "李四", "英语", 23, new Date(), 2000);
        listMember.add(zhangsan);
        listMember.add(lisi);


        Map<String, Object> map = new HashMap<>();

        map.put("country", country);
        map.put("spec", special);
        map.put("memb", listMember);

        /**
         * 如果仅需要键(keys)或值(values)使用方法二。
         * 如果你使用的语言版本低于java 5，或是打算在遍历时删除entries，必须使用方法三。
         * 否则使用方法一(键值都要)。
         */

        System.out.println("----二二二二二-------遍历map中的键：-------------------");
        for (String key : map.keySet()) {

            System.out.println("Key = " + key);

        }
        System.out.println("---二二二二二二----------遍历map中的值：---------------------");
        for (Object value : map.values()) {

            System.out.println("Value = " + value);

        }
        System.out.println("---一一一一一一一-------最常见的一种遍历方法：--------------");
        for (Map.Entry<String, Object> entry : map.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }
        System.out.println("--------使用泛型：-----------------------");

        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry<String, Object> entry = entries.next();

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }
        /**
         * 该种方式看起来冗余却有其优点所在。首先，在老版本java中这是惟一遍历map的方式。
         * 另一个好处是，你可以在遍历时调用iterator.remove()来删除entries，另两个方法则不能。
         * 根据javadoc的说明，如果在for-each遍历中尝试使用此方法，结果是不可预测的。
         */
        System.out.println("--------不使用泛型，有优点所在：-----------------");

        Iterator entries1 = map.entrySet().iterator();

        while (entries1.hasNext()) {

            Map.Entry entry = (Map.Entry) entries1.next();

            String key = (String)entry.getKey();//需强制类型转换否？

            Object value = entry.getValue();

            System.out.println("Key = " + key + ", Value = " + value);

        }
        System.out.println("-----仅做参考--------通过键找值。效率低，明原理：-------------------");

        for (String key : map.keySet()) {

            Object value = map.get(key);

            System.out.println("Key = " + key + ", Value = " + value);

        }

    }
}
