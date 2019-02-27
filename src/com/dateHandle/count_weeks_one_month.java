package com.dateHandle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * 一个月内跨的周数
 * 
 * 自然周数划分：按中国习惯，周一为一周开始，周日为一周结束
 * 一个月的开始 和 结束 自然周，若处在该月的天数大于4天，则算在该月的周数，否则小于4天，则算到另外一个月去
 * 
 * 【2019-01-29，验证过是没问题的！】
 * 
 */
public class count_weeks_one_month {

	public static void main(String[] args) throws ParseException {
		int year = 2019;
		int month = 2;
		// 计算这个月的天数
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);// 月份从0开始，-1才正确
		// cal.set(Calendar.MONTH, month - 1);// 也可以挨个塞值，年同理
		int days = cal.getActualMaximum(Calendar.DATE);// Calendar.DAY_OF_MONTH也对
		System.out.println("首先，计算这个(" + month + ")月有" + days + "天");
		List<weekMonthEntity> weekList = new ArrayList<>();// 用于存放有起止时间的周数
		int this_week_days = 0;
		int which_week = 0;
		for (int i = 1; i <= days; i++) {
			Calendar thisDay = Calendar.getInstance();
			thisDay.set(year, month - 1, i);
			int china_day_of_week = (thisDay.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : (thisDay.get(Calendar.DAY_OF_WEEK) - 1);
			this_week_days++;
			if (this_week_days > 3) {
				if (china_day_of_week == 7) {
					which_week++;// 表示一周的结束
					this_week_days = 0;// 重新计数
					weekMonthEntity newWeek = new weekMonthEntity();
					newWeek.setYear(year);
					newWeek.setMonth(month);
					newWeek.setWeek(which_week);
					newWeek.setBegin(dispartDay(year + "-" + month + "-" + i, -6));
					newWeek.setEnd(year + "-" + month + "-" + i);
					weekList.add(newWeek);
				} else {
					if (i == days) {// 最后几天的归属
						which_week++;// 表示一周的结束
						weekMonthEntity newWeek = new weekMonthEntity();
						newWeek.setYear(year);
						newWeek.setMonth(month);
						newWeek.setWeek(which_week);
						newWeek.setBegin(dispartDay(year + "-" + month + "-" + i, -(china_day_of_week - 1)));
						newWeek.setEnd(dispartDay(year + "-" + month + "-" + i, +(7 - china_day_of_week)));
						weekList.add(newWeek);
					}
				}
			}
		}
		// System.out.println("周集合大小："+ weekList.size());
		// return weekList;
		weekList.stream().forEach(
				item -> System.out.println("第" + item.getWeek() + "周：" + item.getBegin() + " 至 " + item.getEnd()));
	}

	// days为正表示往后；为负表示往前
	private static String dispartDay(String refer, int days) {
		Calendar ca = Calendar.getInstance();// ca.setTime(new Date()); //
												// 设置时间为当前时间
		String[] timeAry = refer.split("-");
		ca.set(Integer.parseInt(timeAry[0]), Integer.parseInt(timeAry[1]) - 1, Integer.parseInt(timeAry[2]));// 月份是从0开始的
		ca.add(Calendar.DATE, days);// 根据days前或后推多少天
		Date resultDate = ca.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(resultDate);
	}

}