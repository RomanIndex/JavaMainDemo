package com.singleMain;

public class SplitPath {
	
	public static void main(String[] args) {
		String testPath = "/yiji/yyy-mm-d/last/";
		
		String doublePath = testPath.replace("/", "\\\\");
		System.out.println(doublePath);
		
		System.out.println(doublePath.substring(0, doublePath.length() - 2));
		
		String[] arr = testPath.split("\\/");
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
		
		/*String rootPath = "D:\\LocalPicDev\\justtest\\111";
        File rootFile = new File(rootPath);
        if (!rootFile.exists()) {
        	rootFile.mkdir();
        	System.out.println("创建成功！");
        }*/
	}

}
