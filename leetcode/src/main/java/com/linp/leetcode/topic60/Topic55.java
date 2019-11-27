package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-27 16:13
 * used for:
 */

/**
 *
 评论 (383)
 题解(115)New
 提交记录
 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个位置。

 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 示例 2:

 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Topic55 {


    /**
     * 1、循环找到0的位置
     * 2、判断0之前的能不能跳出当前0
     * 3、当出现跳不出去的0 返回false
     * 4、都能跳出 着返回true
     * 5、没有0 也返回true；
     */
    public static boolean canJump(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return true;
        }

        boolean canJump = true;
        for(int i = 0;i<nums.length-1;i++) {

            int val = nums[i];
            if(val == 0){
                canJump =false;
                for(int j = i;j>=0;j--){
                    int val_j = nums[j];
                    if(val_j > i-j){
                        canJump =  true;
                    }
                }

                if(!canJump){
                    return false;
                }

            }
        }
        return canJump;
    }

    public static void main(String[] args) {

        int[] num = {2,0,1,0,1};
       System.out.println( canJump(num));

    }

}
