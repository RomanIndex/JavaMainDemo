package com.Java8Try;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.commonEntity.CompareSome;

public class Java8_Compare_some {
	
	public static void main(String[] args) {
		CompareSome map = new CompareSome();
		map.setName("zk");
        map.setAge(13);
        map.setPri(100);
        
        CompareSome map1 = new CompareSome();
		map1.setName("zk");
        map1.setAge(12);
        map1.setPri(100);
        
        CompareSome map11 = new CompareSome();
		map11.setName("zk");
        map11.setAge(45);
        map11.setPri(98);
        
        List<CompareSome> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map11);

        
        // 排序代码如下
        List<CompareSome> collect = list.stream().sorted(Comparator.comparing(CompareSome::getName)
                                                                 .thenComparing(Comparator.comparing(CompareSome::getPri).reversed())
                                                                		 .thenComparing(Comparator.comparing(CompareSome::getAge).reversed()))
                                                         .collect(Collectors.toList());
        
        collect.forEach(ii -> System.out.println(ii.getName() + ":" + + ii.getPri() + "--"+ ii.getAge()));
    }


}
