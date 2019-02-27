package com.dateHandle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class weeksOfMonth {

	public static void main(String[] args) throws Exception {
		// String s = "2017-";
		// for (int i = 1; i <= 12; i++) {
		// System.out.println("*******************************************");
		// System.out.println("月份:" + i);
		printfWeeks(201902);
		// System.out.println("*******************************************");
		//
		// }
	}

	//
	public static void printfWeeks(int yyyymm) throws Exception {
		String date = yyyymm / 100 + "-" + yyyymm % 100;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		Date date1 = dateFormat.parse(date);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date1);
		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("days:" + days);
		int count = 0;
		for (int i = 1; i <= days; i++) {
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = dateFormat1.parse(date + "-" + i);
			calendar.clear();
			calendar.setTime(date2);
			int k = new Integer(calendar.get(Calendar.DAY_OF_WEEK));
			if (k == 1) {// 若当天是周日
				count++;
				System.out.println("第" + count + "周");
				if (i - 6 <= 1) {
					System.out.println("本周开始日期:" + date + "-" + 1);
				} else {
					System.out.println("本周开始日期:" + date + "-" + (i - 6));
				}
				System.out.println("本周结束日期:" + date + "-" + i);
			}
			if (k != 1 && i == days) {// 若是本月最后一天，且不是周日
				count++;
				System.out.println("第" + count + "周");
				System.out.println("本周开始日期:" + date + "-" + (i - k + 2));
				System.out.println("本周结束日期:" + date + "-" + i);
			}
		}
	}
}
