package com.singleMain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Hash_Map_Initial {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int aHundredMillion = 100000;
		
		//-------------第一种-------------------
		Map<Integer, Integer> map = new HashMap<>();

		long s1 = System.currentTimeMillis();
		for (int i = 0; i < aHundredMillion; i++) {
			map.put(i, i);
		}
		long s2 = System.currentTimeMillis();

		System.out.println("未初始化容量，耗时 ： " + (s2 - s1));
		
		//-------------第二种---------------------
		Map<Integer, Integer> map1 = new HashMap<>(aHundredMillion / 2);

		long s5 = System.currentTimeMillis();
		for (int i = 0; i < aHundredMillion; i++) {
			map1.put(i, i);
		}
		long s6 = System.currentTimeMillis();

		System.out.println("初始化容量5000000，耗时 ： " + (s6 - s5));
		
		//-------------第三种-------------------
		Map<Integer, Integer> map2 = new HashMap<>(aHundredMillion);

		long s3 = System.currentTimeMillis();
		for (int i = 0; i < aHundredMillion; i++) {
			map2.put(i, i);
		}
		long s4 = System.currentTimeMillis();

		System.out.println("初始化容量为10000000，耗时 ： " + (s4 - s3));
		
		//----------------------------------------------------
		Map<String, String> map11 = new HashMap<String, String>(1);
		map11.put("hahaha", "hollischuang");

		Class<?> mapType = map11.getClass();
		Method capacity = mapType.getDeclaredMethod("capacity");
		capacity.setAccessible(true);
		System.out.println("capacity : " + capacity.invoke(map11));
	}

}
