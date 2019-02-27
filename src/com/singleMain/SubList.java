package com.singleMain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubList {
	
	public static void main(String[] args) {
		  List<String> list = new ArrayList<String>();
		  list.add("1JavaWeb编程词典");        //向列表中添加数据
		  list.add("2Java编程词典");        //向列表中添加数据
		  list.add("3C#编程词典");         //向列表中添加数据
		  list.add("4ASP.NET编程词典");        //向列表中添加数据
		  list.add("5VC编程词典");         //向列表中添加数据
		  list.add("6SQL编程词典");        //向列表中添加数据
		  Iterator<String> its = list.iterator();     //获取集合迭代器
		  System.out.println("集合中所有元素对象：");
		  while (its.hasNext()) {        //循环遍历集合
		   System.out.print(its.next() + "  ");     //输出集合内容
		  }
		  int initLength = list.size();
		  System.out.println("集合长度："+initLength);
		  int begin = 5;
		  int end = 8;
		  List<String> subList = list.subList(begin - 1, end > initLength ? initLength : end);    //获取子列表
		  System.out.println("\n截取集合中部分元素：");
		  Iterator it = subList.iterator();
		  while (it.hasNext()) {
		   System.out.print(it.next() + "  ");
		  }
		}

}
