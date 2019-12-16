package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-10 19:34
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic63 {


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        List<List<Vo>> l = new ArrayList<>();
        int xLen = obstacleGrid.length;
        int yLen = obstacleGrid[0].length;
        turn(obstacleGrid, xLen, yLen, 0, 0, l, null);
        if (yLen == 0 || xLen == 0) {
            return 0;
        }
        if (yLen == 1 && xLen == 1) {
            if (obstacleGrid[0][0] == 1) {
                return 0;
            } else {
                return 1;
            }
        }


        return l.size();

    }


    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0}};

        System.out.println(uniquePathsWithObstacles(arr));

    }


    public static void turn(int[][] obstacleGrid, int xLen, int yLen, int x, int y, List<List<Vo>> l, List<Vo> item) {
        if (x == xLen - 1 && y == yLen - 1) {
            l.add(item);
            return;
        }
        if (x < xLen - 1) {//向右
            int newX = x + 1;
            int newY = y;
            inst(obstacleGrid, xLen, yLen, newX, newY, l, item);
        }
        if (y < yLen - 1) {//向下
            int newX = x;
            int newY = y + 1;
            inst(obstacleGrid, xLen, yLen, newX, newY, l, item);
        }

    }

    public static void inst(int[][] obstacleGrid, int xLen, int yLen, int newX, int newY, List<List<Vo>> l, List<Vo> item) {

        boolean canTurn = check(obstacleGrid, newX, newY);
        if (canTurn) {
            if (item == null) {
                item = new ArrayList<>();
            }
            item.add(new Vo(newX, newY));
            turn(obstacleGrid, xLen, yLen, newX, newY, l, item);
        }
    }


    public static boolean check(int[][] obstacleGrid, int x, int y) {
        if (obstacleGrid[x][y] == 1) {
            return false;
        }
        return true;
    }


    public static class Vo {
        public int x;
        public int y;

        public Vo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
