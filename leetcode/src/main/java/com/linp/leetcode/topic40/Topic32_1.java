package com.linp.leetcode.topic40;


/**
 * created by : linpeng
 * ON 2019-11-02 16:09
 * used for:
 */

public class Topic32_1 {
    public static int longestValidParentheses(String s) {
        if(s == null || "".equals(s.trim())){
            return 0;
        }

        int len = s.length();
        int indexStart = 0;
        int indexSize = 1;//存放当前长度
        int count = 0;//当前累加结果
        int  result = 0;
        boolean needFor = true;


        while(needFor){

            if(indexStart == len){
                needFor = false;
            }
            if(indexStart + indexSize > len){
                indexStart ++;
                indexSize = 1;
                count = 0;

            }else {


                if ("(".equals(String.valueOf(s.charAt(indexStart + indexSize -1)))) {
                    count += 1;
                } else {
                    count -= 1;
                }


//            String subStr = s.substring(indexStart,indexStart + indexSize);
//            int c = check(subStr);
                if (count < 0) {
                    indexStart = indexStart + indexSize;
                    indexSize = 1;
                    count = 0;
                }else{

                    if (count > 0) {
                        indexSize += 1;
                    }
                    if (count == 0) {
                        if (result < indexSize) {
                            result = indexSize;
                        }
                        indexSize += 1;
                    }
                }
            }


        }

        return result;
    }





    public static int check(String str){
        int len = str.length();
        int count = 0;
        for (int i = 0; i<len; i++){
            if("(".equals(String.valueOf(str.charAt(i)))){
                count++;
            }
            if(")".equals(String.valueOf(str.charAt(i)))){
                count--;
                if(count<0){
                    return -1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(longestValidParentheses(")()())"));
    }


}
