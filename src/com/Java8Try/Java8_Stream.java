package com.Java8Try;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.commonEntity.Student;
import com.singleMain.Generate_Chinese_Name;

public class Java8_Stream {
	
	public static void main(String[] args) {
		
		//
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		//filtered.forEach(System.out::println);
		
		/**
		 * Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。
		 * forEach
		 * 使用 forEach 输出了10个随机数：
		 */
		Random random = new Random();
		//random.ints().limit(10).forEach(System.out::println);
		
		/**
		 * map 方法用于映射每个元素到对应的结果，
		 * 以下代码片段使用 map 输出了元素对应的平方数：
		 */
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取对应的平方数
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		//squaresList.forEach(System.out::println);
		
		/**
		 * filter 方法用于通过设置的条件过滤出元素。
		 * 以下代码片段使用 filter 方法过滤出空字符串：
		 */
		List<String> str = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		// 获取空字符串的数量
		long count = str.stream().filter(string -> string.isEmpty()).count();
		//System.out.println(count);
		
		//-------------------测试一个对实体类集合的操作---------------------
		List<Student> listObj = generatedStudent();
		System.out.println("------用map输出集合-----------");
		
		listObj.stream().map(i -> i.getName()+"："+i.getAge()+"; ").forEach(System.out::print);
		System.out.println();
		listObj.stream().map(j -> addId(j)).forEach(i -> System.out.print(i.getName()+"..."));
		System.out.println();
		System.out.println("-----合理的打印为：--------");
		listObj.forEach(o -> System.out.print(o.getName()+"："+o.getAge()+" "));
		System.out.println();
		System.out.println("------按 年龄 倒序排序------");
		listObj.stream().sorted(Comparator.comparing(Student::getAge).reversed()).map( i -> i.getName()+"："+i.getAge()+"; ").forEach(System.out::print);
		System.out.println();
		System.out.println("-----过滤后的：------");
		listObj.stream().filter(e -> e.getName().contains("司") || e.getName().contains("宫")).forEach(e -> System.out.print(e.getName()+"**"));
		System.out.println();
		//----改进：提取出条件------
		Predicate<Student> containsS = (n) -> n.getName().startsWith("司");
		Predicate<Student> containsG = (n) -> n.getName().startsWith("宫");
		listObj.stream().filter(containsS.or(containsG)).forEach(i -> System.out.print(i.getName()+"--"));
		System.out.println("-----按相同的 姓氏 分组：------");
		Map<String, List<Student>> map = listObj.stream().collect(Collectors.groupingBy(Student::getFirstName));
		map.forEach((k, v) -> {
            System.out.println( "key: " + k + ", value:" + v);
        });
		System.out.println("-----取出年龄最大的人：------");
		List<Integer> nums = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
		//peek():生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），新Stream每个元素被消费的时候都会执行给定的消费函数；
		//System.out.println("sum is:"+ nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).sum());
		System.out.println("peek sum is:"+ nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(p -> judgeNum(p)).skip(2).limit(4).sum());
		System.out.println("map sum is:"+ nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).map(p -> judgeNum(p)).skip(2).limit(4).sum());
	}
	
	private static int judgeNum(int p) {
		if(p > 8){
			System.out.println(p +"：值太大，舍弃");
			p = 1;
		}
		return p * p;
	}

	private static Student addId(Student stu) {
		if(stu.getAge() > 10 && stu.getAge() < 40){
			stu.setName(stu.getName() + "【" + stu.getAge() + "】");
		}else{
			stu.setName(stu.getName()+stu.getAge());
		}
		return stu;
	}

	private static List<Student> generatedStudent() {
		List<Student> reList = new ArrayList<>();
		Generate_Chinese_Name gcnCls = new Generate_Chinese_Name();
		Random random = new Random();
		for(int i = 0; i < 5; i++){
			Student newObj = new Student();
			newObj.setName(gcnCls.createName());
			newObj.setAge(random.nextInt(70));
			reList.add(newObj);
		}
		return reList;
	}

}