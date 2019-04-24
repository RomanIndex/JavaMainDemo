package com.MessyCode;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Probability_main {

    public static void main(String[] args) {
	int baseGJ = 200;
	int GJ = 20;
	int newGJ = 0;
	int FY = 5;
	int HP = 30;
	Random rand = new Random();
	/**
	 * Math.random()结果是个double类型的�?�，区间为[0.0, 1.0�?
	 * rand.nextGaussian()它是取自此随机数生成器序列的、呈高斯（�?�正态�?�）分布的double值，其平均�?�是0.0标准差是1.0
	 * (float)(rand.nextDouble() * (max - min)) + min;生成[min,max)区间的随机数
	 */
	double num;
	Map<String ,Integer> confirmMap = new HashMap<>();
	int countA = 0;
	int countB = 0;
	int countC = 0;
	int countD = 0;
	int countE = 0;
	int countN = 0;
	for(int i = 0; i < 10000; i++){
		baseGJ = baseGJ - GJ;//每次�?20点洗�?
		/**
		 * 整体值都偏高，�?�合�?些核心武将�?�神将�?�活动将领的洗点方式
		 * 各区间范围及概率：A[40,32):10%--B[32,24):25%--C[24,16):30%--D[16,8):25%--E[8,0):10%
		 * 溢出区间可以特殊定义，用途很�?
		 */
	    //num = Math.random() * 100;//完全相等num = rand.nextDouble() * 100;
	    //num = rand.nextGaussian() * 100;//1.0w控制各区间概率，但E高达54%，会给玩家感觉很差！溢出的区�?14%；高斯洗�?--神将专属
	    num = Math.abs(rand.nextGaussian() * 100);//2.1w控制各区间概率，溢出的区�?31%；强化高斯洗�?--神将专属
	    
	    //double randGj = Math.random();//均匀分配3.6w区间内均�?生成（高斯洗�?3.2）（强化高斯洗点6.2�?
	    //double randGj = rand.nextGaussian();//高斯分配2.9w区间内正太分布生成（不安全，会出现极极少数的超大数）（高斯洗�?2.9）（强化高斯洗点6.1�?
	    double randGj = Math.abs(rand.nextGaussian());//强化高斯分配5.1w区间内正太分布生成（生成较大数翻倍，小数�?0）（高斯洗点3.7）（强化高斯洗点7.4�?
	    //人为控制各区间概�?
	    if(num < 10){
	    	countE++;
	    	newGJ = (int)(randGj * 8 + 0);
	    }else if(num >= 10 && num < 35){
	    	countD++;
	    	newGJ = (int)(randGj * 8 + 8);
	    }else if(num >= 35 && num < 65){
	    	countC++;
	    	newGJ = (int)(randGj * 8 + 16);
	    }else if(num >= 65 && num < 90){
	    	countB++;
	    	newGJ = (int)(randGj * 8 + 24);
	    }else if(num >= 90 && num < 100){
	    	countA++;
	    	newGJ = (int)(randGj * 8 + 32);
	    }else{
	    	countN++;
	    	//newGJ = GJ;//普�?�将领情�?
	    	newGJ = (int)(40+Math.random() * GJ);//溢出区间，用于出烧钱神将--以上神将专属洗点都采用这个，实际要调�?
	    }
		
	    /**
	     * ===比较中庸、或低品阶�?�低军衔时可用洗点方�?====
	     * 用正太高斯函数控制各区间概率
	     * 横轴区间(μ-σ,μ+σ)内的面积�?68.268949%
	     * 横轴区间(μ-1.96σ,μ+1.96σ)内的面积�?95.449974%
	     * 横轴区间(μ-2.58σ,μ+2.58σ)内的面积�?99.730020%
	     * 各区间范围及概率：A[40,32):2%--B[32,24):13.5%--C[24,16):68%--D[16,8):13.5%--E[8,0):2%
	     * 这种溢出区间太少，将领洗点上限稳定，适合中小R玩家
	     */
	    /*num = rand.nextGaussian();//落在各区间的概率，溢出区�?0.98%
	    //num = Math.abs(rand.nextGaussian());//2.8w控制各区间概率，溢出的区�?1%,D、E都消失了（解锁功能：强化洗点�?
	    
	    //double randGj = Math.random();//均匀分配1.8w区间内均�?生成/（强化洗�?3.1w�?
	    //double randGj = rand.nextGaussian();//1.9w区间内正太分布生成（强化洗点2.8w�?
	    double randGj = Math.abs(rand.nextGaussian());//强化分配3.6w区间内正太分布生成（强化洗点5.3w�?
	    if(num >= -2.58 && num < -1.96){
	    	countE++;
	    	newGJ = (int)(randGj * 8 + 0);
	    }else if(num >= -1.96 && num < -1){
	    	countD++;
	    	newGJ = (int)(randGj * 8 + 8);
	    }else if(num >= -1 && num < 1){
	    	countC++;
	    	newGJ = (int)(randGj * 8 + 16);
	    }else if(num >= 1 && num < 1.96){
	    	countB++;
	    	newGJ = (int)(randGj * 8 + 24);
	    }else if(num >= 1.96 && num < 2.58){
	    	countA++;
	    	newGJ = (int)(randGj * 8 + 32);
	    }else{
	    	countN++;
	    	newGJ = 20;
	    }*/
		
	    //模拟玩家洗点
	    if(newGJ > 50){
	    	baseGJ = baseGJ + GJ;
	    }else{
	    	if(newGJ >= GJ){
	    		baseGJ = baseGJ + newGJ;
	    	}else{
	    		baseGJ = baseGJ + GJ;
	    	}
	    	//baseGJ = baseGJ - GJ + newGJ;
	    }
	}
	confirmMap.put("A", countA);
	confirmMap.put("B", countB);
	confirmMap.put("C", countC);
	confirmMap.put("D", countD);
	confirmMap.put("E", countE);
	confirmMap.put("N", countN);
	int total = 0;
	for(Map.Entry<String, Integer> cmap : confirmMap.entrySet()){
	    total += cmap.getValue();
	}
	System.out.println("总计�?"+total);
	//NumberFormat nfmt = NumberFormat.getInstance();// 创建�?个数值格式化对象  
	//nfmt.setMinimumIntegerDigits(2);// 设置精确到小数点�?2�? 
	DecimalFormat df = new DecimalFormat("#.00");
	for(Map.Entry<String, Integer> omap : confirmMap.entrySet()){
	    System.out.print(omap.getKey()+":"+omap.getValue());
	    //System.out.println("。�?��?�占比为" + nfmt.format((double)omap.getValue()/total * 100) +"%");
	    System.out.println("。�?��?�占比为" + df.format((double)omap.getValue()/total * 100) +"%");
	}
	System.out.println("�?后GJ为："+baseGJ);
    
//    for(int i = 0; i < 10; i++){
//    	System.out.println(rand.nextGaussian());
//    }

}
}
