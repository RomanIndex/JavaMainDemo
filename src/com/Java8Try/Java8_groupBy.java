package com.Java8Try;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
//import static java.util.stream.Collectors.*;//这种import则导入Collectors类中的所有静态方法，使用时不再需要Collectors.去调用，直接使用即可：
import java.util.stream.Collectors;

import com.commonEntity.Student;

public class Java8_groupBy {
	public static void main(String[] args) {
		//3 apple, 2 banana, others 1
        List<String> strList = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        
        Map<String, List<String>> strMap = strList.stream().collect(Collectors.groupingBy(Function.identity()));
        System.out.println("字符串集合，分组："+ strMap);
        
        //分组List并显示其总数
        Map<String, Long> result = strList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("字符串集合，分组统计数量："+ result);
        
        //Sort a map and add to finalMap
        Map<String, Long> finalMap = new LinkedHashMap<>();
            /**
             * 添加排序（有点复杂）
             * 解释一下Map.Entry
             * Map提供了一些常用方法，如keySet()、entrySet()等方法
             * keySet()方法返回值是Map中key值的集合；
             * entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry；
             * Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
             */
        result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println("什么是map.entrySet()："+ result.entrySet());
        System.out.println("forEachOrdered map集合的排序"+ finalMap);
        
        Map<String, Long> receiveMap = new LinkedHashMap<>();
        receiveMap = result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("collect map集合的排序"+ receiveMap);
        
        /**
         * Student
         */
        Student zhangsan = new Student("id_001", "张三", 15, "湖北");
        Student lisi = new Student("id_002", "李四", 26, "广东");
        Student wangwu = new Student("id_003", "王五", 15, "广东");
        Student zhaoliu = new Student("id_004", "赵六", 15, "四川");
        Student qianqi = new Student("id_005", "钱七", 26, "湖南");
        Student sunba = new Student("id_006", "孙八", 34, "湖南");
        Student sunba2 = new Student("id_006", "孙八", 34, "湖南");
        List<Student> list = Arrays.asList(zhangsan, lisi, wangwu, zhaoliu, qianqi, sunba, sunba2);
        
        /**
         * Tip：在写stream的时候，一定要心里非常清楚当前stream中到底是什么元素，这样你才能结合map,filter,peek等方法来转化你的数据
         */
        
        //1 根据 地址 分组
        Map<String, List<Student>> adMap = list.stream().collect(Collectors.groupingBy(Student::getAddress));
        System.out.println("根据地址分组："+ adMap);
        
        //1.2 
        TreeMap<String, List<Student>> sortAdMap = list.stream().collect(Collectors.groupingBy(Student::getAddress, TreeMap::new, Collectors.toList()));
        System.out.println("根据地址分组并排序："+ sortAdMap);
        
        //1.3
        Map<Integer, Set<String>> byNameMap = list.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getName, Collectors.toSet())));        
        System.out.println("根据年龄分组并排序："+ byNameMap);
        
        //1.4 先根据地区，再根据名字分组
        Map<String, Map<String, List<Student>>> doubleGroupingBy = list.stream().collect(Collectors.groupingBy(Student::getAddress, Collectors.groupingBy(Student::getName)));
        System.out.println("先依据地区，再按名字分组："+ doubleGroupingBy);
        
        //2.1 根据整个实体对象分组计数,当其为String时常使用
        Map<Student, Long> identityResult = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("分组用Function.identity()的作用："+ identityResult);
        
      	//2.2 根据某个属性分组计数
        Map<String, Long> groupByAddress = list.stream().collect(Collectors.groupingBy(Student::getAddress, Collectors.counting()));
        Map<Integer, Long> groupByAge = list.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
        System.out.println("学生集合根据 地址 分组，并统计数量："+ groupByAddress);
        System.out.println("学生集合根据 年龄 分组，并统计数量："+ groupByAge);
        
        //2.3根据 分组的值 对结果进行排序、放进另一个map中并输出
        Map<String, Long> sortedValueMap = new HashMap<>();
        //comparingByKey()是汉字，会发现与预期结果不对
        groupByAddress.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(x -> sortedValueMap.put(x.getKey(), x.getValue()));
        System.out.println("根据 分组的值 排序："+ sortedValueMap);//有问题

        //3.分组，并统计其中一个属性值得sum或者avg:id总和
        Map<String, Integer> result3 = list.stream().collect(Collectors.groupingBy(Student::getAddress, Collectors.summingInt(Student::getAge)));
        System.out.println("分组统计和："+ result3);
        
        //4（Collectors.maxBy前缀不能少）
        Optional<Student> fattest = list.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
        System.out.println("最大年龄的是："+ fattest.get());
        
        //5
        List<String> views = Arrays.asList("wsbs","xafaswzx","b8fw","ad");
        Optional<String> minStr = views.stream().collect(Collectors.minBy(Comparator.comparing(String::length)));
        System.out.println("最短字符串为："+ minStr.get());
        System.out.println("拼接后的字符串为："+ views.stream().map(s -> s).collect(Collectors.joining("-")));
        System.out.println("拼接后的字符串为："+ list.stream().map(s -> s.getAddress()).collect(Collectors.joining("-")));
        
        //6.1
        Map<Boolean,List<Student>> greater20 = list.stream().collect(Collectors.partitioningBy(i -> i.getAge() > 20));
        System.out.println("超过20岁的部分："+ greater20);

	}

}
