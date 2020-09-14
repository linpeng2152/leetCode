package com.linp.algorithm.base;

import java.io.IOException;

/**
 * @Author : linpeng
 * ON 2020-09-14
 * used for:
 */
public class Base {

    /**
     * 取用最大的
     * @param arr
     * @return
     */
    public static int getMax(int[] arr){
        int max=arr[0];
        for(int i = 0;i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 取用最小的
     * @param arr
     * @return
     */
    public static int getMin(int[] arr){
        int min=arr[0];
        for(int i = 0;i<arr.length;i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * 取用 平均值
     * @param arr
     * @return
     */
    public static int getAverage(int[] arr){
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum / arr.length;
    }

    /**
     * 复制
     * @param arr
     * @return
     */
    public static int[] getCopy(int[] arr){
        int len = arr.length;
        int[] arr2 = new int[len];
        for(int i = 0;i<len;i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }

    /**
     * 颠倒顺序
     * @param arr
     */
    public static void reverse(int[] arr){
        int len = arr.length;
        for(int i =0;i<len/2;i++){
            int temp = arr[i];
            arr[i] = arr[len-1-i];
            arr[len-1-i] =temp;
        }
    }


    public static void main(String[] args) throws IOException {
       Long  i = Long.valueOf(System.in.read());
        System.out.println("输入的是 " +i);
    }


}
