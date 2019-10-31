package com.linp.leetcode.topic20;


/**
 * created by : linpeng
 * ON 2019-10-30 11:05
 * used for:
 */

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic11 {

    public static int maxArea(int[] height) {
        int max = 0;
        int item = 0;
        int len = height.length;
        for(int i = 0; i < len; i++){
            int x1 = height[i];
            for(int j = i; j < len; j++){
                int x2 = height[j];
                item = getValue(x1,x2,j-i);
                max = max > item ? max :  item;
            }
        }

        return max;

    }
    public static int getValue(int x1,int x2,int y){
        int min = x1 < x2 ? x1 : x2;
        return min * y;
    }


    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));

    }
}
