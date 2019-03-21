package com.singleMain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) throws ParseException {
        Calendar c = Calendar.getInstance();
        int year = 2019;
        int month = 12;
        int quarter = (month - 1) / 3 + 1;
        System.out.println(month+ "月所属季度："+ quarter);
        System.out.println(quarter + "季度的第一个月："+ (quarter * 3 - 2));
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE));

        SimpleDateFormat yMd = new SimpleDateFormat("yyyy-MM-dd");
        int[] lastMonth = getLastMonth(yMd.parse("2019-03-30"));
        System.out.println("上一个月："+ lastMonth[0] + "---" +lastMonth[1]);
    }

    public static int[] getLastMonth(Date now) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        System.out.println(year + ":::" + month);

        cal.set(year, month - 2, Calendar.DATE);

        int[] ary = new int[2];
        ary[0] = cal.get(Calendar.YEAR);
        ary[1] = cal.get(Calendar.MONTH ) + 1;

        return ary;
    }
}
