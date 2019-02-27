package com.singleMain;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class MapJson {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("id", "ID");
		map.put("name", "name");
		map.put("mobile", "电话");
		map.forEach((k, v) -> System.out.println(k + ":" + v));
		System.out.println(map);
		String jString = new Gson().toJson(map);
		System.out.println(jString);
	}

}
