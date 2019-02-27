package com.singleMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List_remove_count {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		// 默认每个元素至少出现了一次
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String string : list) {
			map.put(string, 1);
		}
		System.out.println("初始的list：" + list);
		System.out.println("初始的map：" + map);
		for (int i = 0; i < list.size(); i++) // 外循环是循环的次数
		{
			for (int j = list.size() - 1; j > i; j--) // 内循环是 外循环一次比较的次数
			{

				if (list.get(i).equals(list.get(j))) {
					list.remove(j);
					if (map.containsKey(list.get(i))) {
						map.put(list.get(i), map.get(list.get(i)) + 1);
					}
				}

			}
		}
		System.out.println("循环处理过的list：" + list);
		System.out.println("循环处理过的map：" + map);
		for (String string : list) {
			System.out.println("去除重复后的元素：" + string + "--重复的次数：" + map.get(string));
		}
	}
}
