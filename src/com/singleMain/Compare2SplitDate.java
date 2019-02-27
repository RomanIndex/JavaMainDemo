package com.singleMain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compare2SplitDate {
	public static void main(String[] args) throws ParseException {
		String strTimes = "2018/7/01 11:37:05 - 2018/7/30 11:37:05";
		String[] timeAry = strTimes.replace("/", "-").split(" - ", 2);
		for(String t : timeAry){
			System.out.println(t);
		}
		
		String setTime = "2018-7-30 11:37:06";
		//Date now = new Date();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date now = format.parse(setTime);
		System.out.println("时间戳："+ now.getTime());
		
		long lt = new Long("1532921826000");
		Date ttt = new Date(lt);
		System.out.println("时间戳转时间："+ format.format(ttt));
		
		Date beginDate = format.parse(timeAry[0]);
		
		if(now.after(beginDate)){
			System.out.println("now > begin");
		}
		Date endDate = format.parse(timeAry[1]);
		
		if(now.before(endDate)){
			System.out.println("now < end");
		}
	}

}
