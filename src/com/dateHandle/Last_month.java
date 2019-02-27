package com.dateHandle;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Last_month {
    public static void main(String[] args) {
	int year = 2018;
	int month = 12;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = Calendar.getInstance();
	cal.set(year, month - 1, 1);
	System.out.println("当月第一天："+sdf.format(cal.getTime()));
	
	int thisMonthDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	System.out.println("这个月有："+ thisMonthDays +"天");
	cal.set(year, month - 1, thisMonthDays);
	cal.add(Calendar.DATE, +1);
	System.out.println("下月第一天："+ sdf.format(cal.getTime()));
	
	//cal.add(Calendar.DATE, -1);
	//System.out.println("上月最后一天："+ sdf.format(cal.getTime()));
    }
    
}
