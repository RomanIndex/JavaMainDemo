package com.singleMain;

public class Auto_purview {
	public static void main(String[] args) {
		boolean f = checkPower(28, 3);
		System.out.println(f);
	}
	
	//userPurview是用户具有的总权限
	//optPurview是一个操作要求的权限为一个整数(没有经过权的!)
	public static boolean checkPower(int userPurview, int optPurview){
		int purviewValue = (int)Math.pow(2, optPurview);
		System.out.println(purviewValue);
		return (userPurview & purviewValue) == purviewValue;
	}

}
