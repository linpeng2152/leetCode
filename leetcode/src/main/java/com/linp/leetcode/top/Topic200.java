package com.linp.leetcode.top;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author : linpeng
 * ON 2021-01-20
 * used for:
 */
public class Topic200 {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [
     * ['1','1','1','1','0'],
     * ['1','1','0','1','0'],
     * ['1','1','0','0','0'],
     * ['0','0','0','0','0']
     * ]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：grid = [
     * ['1','1','0','0','0'],
     * ['1','1','0','0','0'],
     * ['0','0','1','0','0'],
     * ['0','0','0','1','1']
     * ]
     * 输出：3
     *  
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     * 通过次数196,254提交次数377,493
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int numIslands(char[][] grid) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int yL = grid.length;// 高
        int xL = grid[0].length; // 宽


        for (int y = 0; y < yL; y++) {
            for (int x = 0; x < xL; x++) {
                if (grid[y][x] == '0') {
                    continue;
                }
                if (isT(grid, x, y, xL, yL)) {
                    set1.add(getT(grid, x, y, xL, yL));
                }
            }
        }


        return set1.size();
    }


    private static String getT(char[][] grid, int x, int y, int xL, int yL) {

        int newX = x;
        int newY = y;

        for (; ; ) {
            int i = 0;
            if (newX == 0) {
            } else {
                newX = newX - 1;
                if (grid[newY][newX] == '0') {
                    newX = newX + 1;
                }else {
                    i ++ ;
                }
            }

            if (newY == 0) {
            } else {
                newY = newY - 1;
                if (grid[newY][newX] == '0') {
                    newY = newY + 1;
                } else {
                    i ++ ;
                }
            }

            if (i == 0) {
                break;
            }

        }

        return newX + "_" + newY;
    }

    private static boolean isT(char[][] grid, int x, int y, int xL, int yL) {
        return isC(grid, x, y, xL, yL, 1) &&
                isC(grid, x, y, xL, yL, 2) &&
                isC(grid, x, y, xL, yL, 3) &&
                isC(grid, x, y, xL, yL, 4);
    }

    private static boolean isC(char[][] grid, int x, int y, int xL, int yL, int type) {
        if (1 == type) {//向上
            int newY = y - 1;

            if (newY == -1 || newY == 0 || grid[newY][x] == '0') {
                return true;
            }

            if (grid[newY][x] == '1') {
                return isC(grid, x, newY, xL, yL, 1);
            }

        }
        if (2 == type) {//下
            int newY = y + 1;
            if (newY == yL || newY == yL - 1 || grid[newY][x] == '0') {
                return true;
            }
            if (grid[newY][x] == '1') {
                return isC(grid, x, newY, xL, yL, 2);
            }
        }
        if (3 == type) {//左
            int newX = x - 1;
            if (newX == -1 || newX == 0 || grid[y][newX] == '0') {
                return true;
            }
            if (grid[y][newX] == '1') {
                return isC(grid, newX, y, xL, yL, 3);
            }
        }
        if (4 == type) {//右
            int newX = x + 1;
            if (newX == xL || newX == newX - 1 || grid[y][newX] == '0') {
                return true;
            }
            if (grid[y][newX] == '1') {
                return isC(grid, newX, y, xL, yL, 4);
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception  {

        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '1'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '0'}};
        char[][] grid1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'0', '0', '0', '0', '0'}};
//        char[][] grid2 = {{'0','1','0'},{'1','0','1'},{'0','1','0'}};
        char[][] grid2 = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        char[][] grid3 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

//        System.out.println(numIslands(grid));
//        System.out.println(numIslands(grid1));
//        System.out.println(numIslands(grid2));

        test();




    }

    public static void test() throws Exception {
        SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        // 2020年12月26日周六
        c.set(Calendar.DATE, 1);
        System.out.println("YYYY-MM-dd = " + df1.format(c.getTime()));
        System.out.println("yyyy-MM-dd = " + df2.format(c.getTime()));

        // 分割线
        System.out.println("========================");

        // 2020年12月27日 周日
        c.add(Calendar.DATE, 1);
        System.out.println("YYYY-MM-dd = " + df1.format(c.getTime()));
        System.out.println("yyyy-MM-dd = " + df2.format(c.getTime()));
    }


}
