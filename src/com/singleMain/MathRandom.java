package com.singleMain;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class MathRandom {
	public static void main(String[] args) {
		System.out.println((Math.random()*4));
		System.out.println((-9)%1);
		System.out.println(getDouble());
        xiangchu();
	}
	
	/**
     * 随机生成指定精确度的小数
     * @return
     * 左右开闭都有。。。可参考
     * https://blog.csdn.net/dj741/article/details/69666661
     */
    public static double getDouble(){
        DecimalFormat df = new DecimalFormat("#.0");
        //Random rand = new Random();
        //int a = rand.nextInt(50 - 10 + 1) + 10;
        double d = 1 + Math.random() * (5 - 1);
        double dd = 80 + Math.random() * (100 - 80);
        System.out.println(Double.valueOf(df.format(d)) + "");
        System.out.println(Double.valueOf(df.format(dd)));
        
        //int randNumber = rand.nextInt(MAX - MIN + 1) + MIN

        return 0;
    }

    public static void xiangchu(){
        double sub = 56.53;
        int mom = 100;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        String k = df.format(sub * 100.00 / mom) + "%";
        System.out.println("只取整数："+ k);

        float num = (float)sub / mom;
        DecimalFormat df2 = new DecimalFormat("0.00");//格式化小数
        String s = df2.format(num);//返回的是String类型
        System.out.println("保留两位小数："+ s);

        percent(56, 100);
    }

    public static void percent(int sub, int mom){
        //这里的数后面加“D”是表明它是Double类型，否则相除的话取整，无法正常使用
        double percent = (double) sub / mom;

        //输出一下，确认你的小数无误
        System.out.println("小数：" + percent);

        //获取格式化对象
        NumberFormat nt = NumberFormat.getPercentInstance();

        //设置百分数精确度2即保留两位小数
        //nt.setMinimumFractionDigits(2);
        nt.setMinimumFractionDigits(0);

        //最后格式化并输出
        System.out.println("百分数：" + nt.format(percent));
    }

}
