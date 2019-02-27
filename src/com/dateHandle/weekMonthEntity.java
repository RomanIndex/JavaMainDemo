package com.dateHandle;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class weekMonthEntity {

    private int year;
    
    private int month;
    
    private int week;//第几周，从1开始
    
    private String begin;
    
    private String end;
    
    //取上个月，最后一天
    public String getLastMonth() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = Calendar.getInstance();
	cal.set(year, month - 1, 1);//用本月第一天实例化cal
	cal.add(Calendar.DATE, -1);//上一天就是上月最后一天
	
	return sdf.format(cal.getTime());
    }
    
    //取下个月，第一天
    public String getNextMonth() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = Calendar.getInstance();
	cal.set(year, month - 1, 1);//先用本月实例化cal
	int thisMonthDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//计算当前月总天数
	cal.set(year, month - 1, thisMonthDays);//再用本月最后一天实例化cal
	cal.add(Calendar.DATE, +1);//下一天就是下月第一天
	
	return sdf.format(cal.getTime());
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
