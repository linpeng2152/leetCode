package com.linp.leetcode.topic100;


/**
 * created by : linpeng
 * ON 2019-12-20 19:04
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic85 {


    public static void main(String[] args) {
        char[][] arr = {
                {'1', '0', '1', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(arr));

    }

    /**
     * 1、循环找出 每个位置为'1'时 的最大值 这个就是最大值
     * 2、比如 x，y  找出 当前 x 行 y 能达到的最大值 放入到List<Y>
     * 3、找出 List<Y> 的最大矩形。这就是 x，y 位置的最大值。
     */
    public static int maximalRectangle(char[][] matrix) {


        int m = matrix.length;
        if(m == 0){
            return 0;
        }

        int n = matrix[0].length;
        int max = 0;


        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int val = matrix[x][y];
                if (val == '1') {
                    int curMax = getMax(matrix, x, y, m, n);
                    if (max < curMax) {
                        max = curMax;
                    }
                }
            }
        }

        return max;
    }

    public static int getMax(char[][] matrix, int x, int y, int m, int n) {
        int max = 0;
        List<Integer> yList = new ArrayList<>();
        for (int i = x; i < m; i++) {
            int val = matrix[i][y];
            if (val == '0') {
                break;
            } else {
                int curYY = getY(matrix, i, y, m, n) + 1;
                yList.add(curYY - y);
            }
        }
        int[] arr = new int[yList.size()];
        for (int i = 0; i < yList.size(); i++) {
            arr[i] = yList.get(i);
        }

        max = largestRectangleArea(arr);

        return max;
    }

    public static int getY(char[][] matrix, int x, int y, int m, int n) {
        int yy = y;
        for (int i = y; i < n; i++) {
            int val = matrix[x][i];
            if (val == '1') {
                yy = i;
            } else {
                return yy;
            }
        }
        return yy;
    }

    /**
     * 循环找出每一项 的最大距形 比较
     * 每一项 向左找出 距形 的开始位置
     * 每一项 向右找出 距形 的结束位置
     * （结束位置 - 开始位置） * 高度 就是 矩形的 面积
     */
    public static int largestRectangleArea(int[] heights) {
        int max = 0;

        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int curMax = getRectangle(heights, i);
            if (curMax > max) {
                max = curMax;
            }
        }
        return max;
    }

    public static int getRectangle(int[] heights, int i) {
        int left = getLeft(heights, i);
        int right = getRight(heights, i);
        int val = heights[i];

        return val * (right - left + 1);
    }

    public static int getLeft(int[] heights, int i) {

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

    public static int getRight(int[] heights, int i) {
        int val = heights[i];
        int index = i;
        int len = heights.length - i;
        for (int j = 1; j < len; j++) {
            if (heights[i + j] >= val) {
                index = i + j;
            } else {
                return index;
            }
        }
        return index;
    }


}
