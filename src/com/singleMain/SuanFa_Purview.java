package com.singleMain;

import java.math.BigInteger;

public class SuanFa_Purview {
	public static void main(String[] args) {
		//十进制转换为二进制
        //System.out.println(Integer.toBinaryString(222));
		/**
		 * Java中n^2表示n和2进行异或
		 * 求平方：Math.pow(n,2)
		 * Math.pow(2,N)，N值不能太大，否则会失效，测试当N > 30时，开始失效
		 */
		int totalPurview = (int) (Math.pow(2,30) + Math.pow(2,29));
		System.out.println(totalPurview);
		int hasPurview = (int) (Math.pow(2,4));
		boolean flag = (totalPurview & hasPurview) == hasPurview ? true : false;
		System.out.println(flag);
		
		/*int a=1; // 001 状态a
        int b=2; // 010 状态b
        int c=4; // 100 状态c

        int ab = a | b; // 001 | 010 = 011 初始状态

        System.out.println(ab | c); // 011 | 100 = 111 添加c的状态
        System.out.println(ab & (~b)); // 011 & (~010) = 011 & 101 = 001 去除b的状态

        System.out.println((ab & b) == b); // 011 & 010 = 010 判断是否有b的权限：(ab & b)==b
        System.out.println((ab & c) == c); // 011 & 100 = 000
*/        
        //初始权限
		String initRight = "0";
        BigInteger b36 = new BigInteger(initRight, 36);
        //赋予
        b36 = b36.setBit(Integer.parseInt("1"));
        b36 = b36.setBit(Integer.parseInt("36"));
        //回收
        b36 = b36.clearBit(Integer.parseInt("1"));
        //检查
        boolean has = b36.testBit(Integer.parseInt("1"));
        System.out.println("b36最终值："+ b36 +"，是否具有："+ has);
	}
	
	//userPurview是用户具有的总权限
	//optPurview是一个操作要求的权限为一个整数（没有经过权的！）
	public static boolean checkPower(int userPurview, int optPurview){
		int purviewValue = (int)Math.pow(2, optPurview);
		return (userPurview & purviewValue) == purviewValue;
	}

}
