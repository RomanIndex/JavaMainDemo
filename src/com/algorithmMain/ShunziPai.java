package com.algorithmMain;

import java.util.Arrays;
import java.util.Random;

public class ShunziPai {
	private static Random random = new Random(); // 随机数对象

	private static int[] array = new int[] {
			114, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 
			214, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 
			314, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 
			414, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 
			100, 200 }; // 54张牌, A按14处理

	public static void main(String[] args) {
		/*int i = 0;
		// 打印10组顺子
		while (i < 10) {
			if (check()) {
				i++;
			}
		}*/
		System.out.println(check());
	}

	public static boolean check() {
		int[] check = checkout(5);
		/*int[] real = new int[5];
		for (int i = 0; i < check.length; i++) {
			real[i] = check[i] % 100;
		}*/
		int[] real = {10, 12, 13, 14, 0};//数组初始化（自定义校样）
		// 按大小排序
		Arrays.sort(real);
		boolean isLink = true;
		int kingCount = 0;
		for (int i = 0; i < real.length; i++) {
			// 有重复的并且不是0的,或者包含2的都不是顺子
			if (real[i] == 2) {
				isLink = false;
				break;
			}
			if (i > 0 && real[i] == real[i - 1] && real[i] != 0) {
				isLink = false;
				break;
			}
			//统计大小王的数量
			if (real[i] == 0) {
				kingCount++;
			}
		}
		// 判断间距
		if (real[real.length - 1] - real[kingCount] > real.length - 1) {
			isLink = false;
		}
		
		//if (isLink) {
			StringBuffer sbCheck = new StringBuffer();
			StringBuffer sbLink = new StringBuffer();
			for (int i = 0; i < real.length; i++) {
				sbLink.append((real[i] < 10 ? " " + real[i] : (real[i] == 14 ? " A" : real[i])) + (i == real.length - 1 ? "" : ", "));
				sbCheck.append((check[i] < 10 ? " " + check[i] : check[i]) + (i == check.length - 1 ? "" : ", "));
			}
			System.out.println(sbCheck.toString() + "     " + sbLink.toString() + "-------" + (isLink ? "1" : "0"));
		//}
		return isLink;
	}

	private static int[] checkout(int length) {
		int[] check = new int[length];
		int i = 0;
		while (i < length) {
			int sn = random.nextInt(array.length); // 随机序号
			boolean isContain = false;
			for (int k = 0; k < length && k < i + 1; k++) {
				if (check[k] == array[sn]) { // 重复抽取
					isContain = true;
					break;
				}
			}
			if (!isContain) {
				check[i] = array[sn];
				i++;
			}
		}
		return check;
	}
}