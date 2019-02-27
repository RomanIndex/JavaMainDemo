package com.singleMain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Collection_input_distinct {
	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		System.out.println("请输入数字个数：");
		int size = sc.nextInt();
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			int x = i + 1;
			System.out.println("请输入第" + x + "个数字：");
			int num = sc.nextInt();
			nums.add(num);
		}*/
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("请输入一串整数并在输入时用英文逗号隔开：");
		String inputString = new Scanner(System.in).next().toString();

		if (inputString != null && !inputString.isEmpty()) {
			String[] strArray = inputString.split(",");
			for (String str : strArray) {
				list.add(Integer.parseInt(str));
			}
			//ArrayList<ArrayList<Integer>> allsubsets = getSubsets(list);
			HashSet<ArrayList<Integer>> allsubsets = getSubsets(list);
			for (ArrayList<Integer> subList : allsubsets) {
				System.out.println(subList);
			}

		}
	}

	public static HashSet<ArrayList<Integer>> getSubsets(ArrayList<Integer> subList) {
		//ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> allsubsets = new HashSet<>();
		int max = 1 << subList.size();
		for (int loop = 0; loop < max; loop++) {
			int index = 0;
			int temp = loop;
			ArrayList<Integer> currentCharList = new ArrayList<Integer>();
			while (temp > 0) {

				if ((temp & 1) > 0) {
					currentCharList.add(subList.get(index));
				}
				temp >>= 1;
				index++;
			}
			allsubsets.add(currentCharList);
		}

		return allsubsets;
	}

}