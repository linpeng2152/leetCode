package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-08 14:42
 * used for:
 */

public class Topic42 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * <p>
     * <p>
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int trap(int[] height) {
        int trap = 0;

        int len = height.length;


        int indexMax = -1;

        for (int i = 0; i < len; ) {
            indexMax = -1;
            if (height[i] == 0) {
                i++;
                continue;
            }
            if (i == len - 1) {
                return trap;

            }
            if(height[i+1] >= height[i]){
                i++;
                continue;
            }


            for (int j = i + 1; j < len; j++) {
                if(height[j] >= height[i]){
                    trap += getTrap(height,i,j);
                    i = j;
                    break;
                }
                if(indexMax == -1){
                    indexMax = j;
                }else
                if(height[indexMax] < height[j]){
                    indexMax = j;
                }

                if(j == len -1){
                    trap += getTrap(height,i,indexMax);
                    i = indexMax;
                    break;
                }


            }

        }
        return trap;
    }


    public static int getTrap(int[] height, int indexX, int indexY) {
        int x = height[indexX];
        int y = height[indexY];

        int mid = x > y ? y : x;

        int trap = 0;
        for (; indexX < indexY; indexX++) {
            if(mid < height[indexX]){
                continue;
            }
            trap += (mid - height[indexX]);
        }

        return trap;
    }


    public static void main(String[] args) {
        System.out.println(trap(new int[]{5,5,1,7,1,1,5,2,7,6}));
    }

}
