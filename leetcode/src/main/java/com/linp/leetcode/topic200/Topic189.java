package com.linp.leetcode.topic200;

/**
 * @Author : linpeng
 * ON 2020-12-07
 * used for:
 */
public class Topic189 {


    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * 说明:
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     * 通过次数182,526提交次数417,931
     * 在真实的面试中遇到过这道题？
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int index = 0;
        int temp1;
        int temp2=nums[0];

       if(len%k==0){
           for(int j=0;j<k;j++){
               index = j;
               temp2 = nums[index];
               for(int i = 0;i < len/k;i++){
                   int newInx = (index + k) % len ;
                   temp1 = nums[newInx];
                   nums[newInx] = temp2;
                   temp2 = temp1;
                   index = newInx;
               }
           }

       }else {

           for(int i = 0;i<nums.length;i++){
               int newInx = (index + k) % len ;
               temp1 = nums[newInx];
               nums[newInx] = temp2;
               temp2 = temp1;
               index = newInx;
           }
       }

        System.out.print(5%4);

    }



    public static void main(String[] a){
        int[] arr = {1,2,3,4,5,6};
        rotate(arr,4);

    }
}
