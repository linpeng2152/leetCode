package com.linp.algorithm.chapter1_1;

/**
 * @Author : linpeng
 * ON 2020-09-14
 * used for:
 */
public class Topic1_1_10 {

    public static void main(String[] args) {

//        二分查找
//        int[] arr = {1,2,3,5,6,8,9,11,123};
//        System.out.println("二分查找 位置 "+searchBinary(arr,3));


    }


    /**
     * 二分查找
     * 查处某一个数字的位置
     *
     * @param arr    有序的数组 从小到大
     * @param target 需要查找的数字
     * @return -1 表示不存在、其余表示位置
     */
    public static int searchBinary(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < arr[mid]) {
                hi = mid - 1;
            } else if (target > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;

    }


}
