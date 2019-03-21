package com.singleMain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args) {
        String dateStr = "2019-03-06 22:23:15";
        int hour = 6;
        addDateMinut(dateStr, hour);
    }

    /**
     * 给时间加上几个小时
     * @param dayStr 当前时间 格式：yyyy-MM-dd HH:mm:ss
     * @param hour 需要加的时间
     * @return
     */
    public static String addDateMinut(String dayStr, int hour){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dayStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (date == null)
            return "";
        System.out.println("front:" + sdf.format(date)); //显示输入的日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        SimpleDateFormat sdfSpecial = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        System.out.println("after:" + sdfSpecial.format(date));  //显示更新后的日期
        cal = null;
        return sdf.format(date);

    }
}
