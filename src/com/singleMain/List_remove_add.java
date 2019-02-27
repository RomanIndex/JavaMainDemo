package com.singleMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class List_remove_add {

	public static void main(String[] args) {
		List<String> asList = Arrays.asList("导师", "领队", "队员", "队员");
		//asList.add("aaaa");
		asList.stream().forEach(item -> System.out.println(item));
		//List<String> asSub = Arrays.asList("队员");
		//asList.removeAll(asSub);
		
		List<String> list = new ArrayList<>();
		list.add("导师");
		list.add("领队");
		list.add("队员");
		list.add("队员");
		
		list.add("ooo");
		list.remove("导师");
		list.stream().forEach(item -> System.out.println(item));
		
		System.out.println(list.contains("队员"));
		
		List<String> sub = new ArrayList<>();
		//sub.add("队员");
		
		for(String str : list){
			boolean flag = false;
			int index = -1;
			for(int i = 0; i <= sub.size(); i++){
				if(str.equals(sub.get(i))){
					index = i;
					flag = true;
					break;
				}
			}
			
			if(flag){
				System.out.println(str + "相等。。。");
				sub.remove(index);
			}else{
				System.out.println("子的没有"+ str);
			}
		}
		
		//list.remove("队员");
		List<String> filter = list.stream().filter(item -> item.equals(null)).collect(Collectors.toList());
		
		List<String> split = Arrays.asList("aadddcc,".split(",", 2));
		
		split.stream().forEach(item -> System.out.println(item));
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		System.out.println(numbers.stream().filter(num -> num < 1).mapToInt(ii -> ii).sum());
		

	}

}
