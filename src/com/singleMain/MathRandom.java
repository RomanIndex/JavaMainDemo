package com.singleMain;

import java.text.DecimalFormat;
import java.util.Random;

public class MathRandom {
	public static void main(String[] args) {
		System.out.println((Math.random()*4));
		System.out.println((-9)%1);
		System.out.println(getDouble());
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

}
