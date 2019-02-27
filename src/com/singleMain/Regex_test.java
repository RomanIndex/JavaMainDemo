package com.singleMain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_test {
	public static void main(String[] args) {
		//正则规则
		//Pattern pattern = Pattern.compile("^/(wx/caim|getTicket)+(/\\w*/?\\w*)*");
		Pattern pattern1 = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");//电话号码
		Pattern pattern11 = Pattern.compile("^1[3,5,7,8][0-9]{9}$");//电话号码
		Pattern pattern2 = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");//[中括号内的.不需要\.这样转义]
		Pattern pattern3 = Pattern.compile("\\d");
		
		//被校验的字符串
		String str = "sa245gy45";
		Matcher match = pattern3.matcher(str);
		
		System.out.println(str.replaceAll("\\D", ""));
		System.out.println(str.replaceAll("\\d", "%s"));
		/**
		 * 可以定义三个变量
		 * 1、Pattern pattern = Pattern.compile("\\d");
		 * 2、String matcherStr = "sa245gy45";
		 * 3、String replaceStr = "";
		 */
		String dealStr = pattern3.matcher(str).replaceAll("");//regex.matcher(str).replaceAll("")
		System.out.println("dealStr："+dealStr);
		
		if(match.matches()){
            System.out.println("success!!!");
        }else{
        	System.out.println("defeate..");
        }
		System.out.println("end!");
	}

}
