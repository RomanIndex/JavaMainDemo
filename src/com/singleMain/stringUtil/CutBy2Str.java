package com.singleMain.stringUtil;

public class CutBy2Str {

    public static void main(String[] args) {
        String str = "[365阿里斯顿";
        System.out.println(cutByDoubleStr(str, "[", "]"));

    }

    private static String cutByDoubleStr(String str, String beginStr, String endStr) {
        int begin = str.indexOf(beginStr);
        int end = str.indexOf(endStr);
        System.out.println(begin + " -- " + end);
        if(begin < 0 || end < 0){
            return str.replace(beginStr, "").replace(endStr, "");
        }
        String cutStr = str.substring(begin, end + 1);
        System.out.println(cutStr);
        return str.replace(cutStr, "");
    }
}
