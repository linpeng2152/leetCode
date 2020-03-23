package com.linp.leetcode.topic100;


/**
 * created by : linpeng
 * ON 2019-12-20 11:39
 * used for:
 */

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic84 {

    public static void main(String[] args) {

        int[] nums = {2,1,2}; //

       System.out.println(largestRectangleArea(nums));
    }


    /**
     * 循环找出每一项 的最大距形 比较
     * 每一项 向左找出 距形 的开始位置
     *  每一项 向右找出 距形 的结束位置
     *  （结束位置 - 开始位置） * 高度 就是 矩形的 面积
     */
    public static int largestRectangleArea(int[] heights) {
        int max = 0;

        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int curMax =  getRectangle( heights,i);
            if(curMax > max){
                max = curMax;
            }
        }
        return max;
    }

    public static int getRectangle(int[] heights ,int i){
        int left = getLeft(heights,i);
        int right = getRight(heights,i);
        int val = heights[i];

        return val * (right-left + 1);
    }

    public static int getLeft(int[] heights ,int i) {

        int val = heights[i];
        int index = i;
        for (int j = 0; j <= i; j++) {
                if (heights[i - j] >= val) {
                    index = i - j;

                } else {
                    return index;
                }
        }
        return index;
    }

    public static int getRight(int[] heights, int i){
        int val = heights[i];
        int index = i;
        int len = heights.length - i;
        for(int j = 1; j < len; j++){
            if(heights[i+j] >= val){
                index = i + j;
            }else{
                return index;
            }
        }
        return index;
    }



}
