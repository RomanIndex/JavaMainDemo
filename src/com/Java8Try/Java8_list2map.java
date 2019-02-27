package com.Java8Try;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.commonEntity.Grade;
import com.commonEntity.GradeView;
import com.commonEntity.Student;

public class Java8_list2map {

	public static void main(String[] args) {
		/**
         * Student
         */
        Student zhangsan = new Student("id_001", "张三", 15, "湖北");
        Student lisi = new Student("id_002", "李四", 26, "广东");
        Student wangwu = new Student("id_003", "王五", 15, "广东");
        Student zhaoliu = new Student("id_004", "赵六", 15, "四川");
        Student qianqi = new Student("id_005", "钱七", 26, "湖南");
        Student sunba = new Student("id_006", "孙八", 34, "湖南");
        Student sunba2 = new Student("id_007", "孙八", 34, "湖南");
        List<Student> list = Arrays.asList(zhangsan, lisi, wangwu, zhaoliu, qianqi, sunba, sunba2);
        
        Student a = new Student("id_010", "A", 15, "湖北");
        Student b = new Student("id_011", "B", 26, "广东");
        Student c = new Student("id_012", "C", 15, "广东");
        Student d = new Student("id_013", "D", 15, "四川");
        Student e = new Student("id_014", "E", 26, "湖南");
        Student f = new Student("id_015", "F", 34, "湖南");
        Student g = new Student("id_016", "G", 34, "湖南");
        List<Student> listS = Arrays.asList(a, b, c, d, e, f, g);
        
        List<Student> listZ = Arrays.asList(a, b, c);
        
        Grade g1 = new Grade("grade_001", "阳光班", "光头强", list, 998);
        Grade g2 = new Grade("grade_002", "平行班", "无厘头", listZ, 512);
        Grade g3 = new Grade("grade_003", "渣渣班", "混日子", listZ, 266);
        Grade g4 = new Grade("grade_003", "渣渣班", "混日子", listS, 365);
        Grade g5 = new Grade("grade_002", "平行班", "无厘头", listS, 688);
        Grade g6 = new Grade("grade_003", "渣渣班", "混日子", list, 365);
        List<Grade> grades = Arrays.asList(g1, g2, g3, g4, g5, g6);
        //Q:把每个班  不重名 的学生 提出来
        //1：分组，并将 list<学生> 合并起来
        Map<String, List<Student>> gradeMap = grades.stream().collect(Collectors.toMap(Grade::getGradeName, Grade::getMembers, 
        		(key1, key2) -> Stream.of(key1, key2).flatMap(Collection::stream).distinct().collect(Collectors.toList())));
        //2:map转list，keySet()是关键
        List<GradeView> gradeViews = gradeMap.keySet().stream().map(key -> {
        	GradeView view = new GradeView();
        	view.setGradeName(key);
        	String ads = gradeMap.get(key).stream().map(i -> i.getAddress()).distinct().collect(Collectors.joining("|"));
        	view.setStudents(ads);
        	return view;
        }).collect(Collectors.toList());
        
        gradeViews.forEach(n -> System.out.println(n.getGradeName() +"："+ n.getStudents()+ "；"));
        
     	// 把list转map,{k=lv,vaule=并为自身}  .Student-> Student或Function.identity()
        Map<String, Student> map = listS.stream().collect(Collectors.toMap(Student::getAddress, Function.identity(), (key1, key2) -> key1));
        System.out.println("map："+map);
        
        //map 转 list，关键map.values()即可
        //Map<String, Student> map_hebing = map.values().stream().collect();
        
        map.forEach((key, val) -> {System.out.println(key +"："+ val +"；");});
        
        map.forEach((k,v)->{
			if(k.equals("湖南")){
				System.out.println("hello "+k);
			};
			if(v.getAge() > 20 && v.getAge() < 30){
				System.out.println(v.getName()+ " you age is "+ v.getAge());
			}
		});
        
        //用途：实现一个集合转map，并实现了去重（达到 合并 显示 的效果）
        Map<String, String> map2 = listS.stream().collect(Collectors.toMap(Student::getAddress, Student::getName, (key1, key2) -> key1+"、"+key2));
        System.out.println("__map2："+map2);
        
     	// 合并
        list.forEach(n -> {
        	// 如果等级一致
        	if (map.containsKey(n.getAddress())) {
        		Student obj = map.get(n.getAddress());
        		//把名字复制过去（即 用map的值 覆盖 list里面的值）
        		n.setName(obj.getName());
    		}
    	});
        System.out.println("list："+ list);
        list.stream().forEach(i -> System.out.print(i.getAddress()+"："+i.getName()+"；"));

	}

}
