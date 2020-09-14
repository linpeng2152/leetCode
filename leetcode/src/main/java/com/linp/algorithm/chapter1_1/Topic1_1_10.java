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
        //开始时的最小值位置
        int lo = 0;
        //开始时的最大值位置
        int hi = arr.length - 1;

        //当移动时 发现 最小值的位置 大于 最大值的位置时 则结束查找
        while (lo <= hi) {

            //找出中间值
            int mid = lo + (hi - lo) / 2;

            //中间值比 > 目标值  则将位置最大值往中间移动
            if (target < arr[mid]) {
                hi = mid - 1;

            }
            //中间值比 < 目标值  则将位置最小值往中间移动
            else if (target > arr[mid]) {
                lo = mid + 1;
            }
            //中间值比 == 目标值  则直接返回位置
            else {
                return mid;
            }
        }

        return -1;

    }


}
