package com.algorithmMain;

public class MoreThanHalf {

	public static void main(String[] args) {
		int[] num = { 1, 2, 2, 2, 2, 2, 2, 4, 2, 4, 6, 4, 2, 6, 8, 2, 7, 7 };
		System.out.println(moreThanHalf(num));
	}

	public static int moreThanHalf(int[] num) {
		int result = -1;
		int times = 0;
		for (int i = 0; i < num.length; i++) {
			if (times == 0) {
				result = num[i];
				times++;
			} else {
				if (num[i] == result) {
					times++;
				} else {
					times--;
				}
			}
		}
		return result;
	}

}