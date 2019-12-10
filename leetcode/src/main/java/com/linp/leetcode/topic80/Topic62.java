package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-10 16:35
 * used for:
 */

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic62 {
    public static int s = 0;


    /**
     * 超时
     */
    public static int uniquePaths(int m, int n) {
        s = 0;
        inst(m - 1, n - 1);
        return s;
    }


    public static void inst(int r, int d) {
        if (r == 0 || d == 0) {
            s = s + 1;
            return;
        }
        if (r != 0) {//向右
            inst(r - 1, d);
        }
        if (d != 0) {//向下
            inst(r, d - 1);
        }
    }


    public static void main(String[] args) {
        Long s = System.currentTimeMillis();
        System.out.println(uniquePaths(51, 9));
        Long l = System.currentTimeMillis();
        System.out.println(l - s);

    }

}
