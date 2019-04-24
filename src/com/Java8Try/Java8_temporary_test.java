package com.Java8Try;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.commonEntity.Student;

public class Java8_temporary_test {
	public static void main(String[] args) {
		Student s1 = new Student("111", "张", 23, "");
		Student s2 = new Student("222", "李", 56, "");
		Student s3 = new Student("333", "王", 46, "");
		Student s4 = new Student("333", "王4", 446, "");
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);

		//直接操作原集合
		/*list = list.stream().filter(i -> i.getAge() > 100).collect(Collectors.toList());
		list.stream().forEach(e -> System.out.println("操作原集合："+ e.getName()));*/

		long size = list.stream().skip(0).limit(3).count();
		System.out.println("skip(0).limit(x) = "+ size);
		
		//取集合 对象 的属性值
		String filter = list.stream().filter(each -> each.getAge() == 23).map(i -> i.getName()).collect(Collectors.toList()).get(0);
		System.out.println(filter);
		//获取索引
		List<Object> students = IntStream.range(0, list.size()).mapToObj(i -> handle(list.get(i), i)).collect(Collectors.toList());
		students.forEach(i -> System.out.print(((Student) i).getName()));
		//根据对象属性 去重
		//List<Student> unique = list.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getId()))), ArrayList::new));
		
		List<Student> unique = list.stream().filter(distinctByKey(o -> o.getId())).collect(Collectors.toList());
		unique.forEach(ii -> System.out.printf(ii.getName()));
	}

	private static Object handle(Student student, int i) {
		System.out.println(student.getName() + "--" + i);
		return student;
	}
	
	//自定义 去重方法关键：
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

}
