package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-13 15:07
 * used for:
 */

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic48 {

    /**
     * 思路
     * <p>
     * 1、根据规律 （x，y）➡️ （y，n -x） 将一个值移动到新的位置
     * 2、循环 直到 回到 (x,y)
     * 3、这样呀就完成了一层的循环 、再往里面推进一层 循环 以此类推 完成所有循环
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        //(x,y)
        int x, y;

        int len = matrix.length;
        int n = len - 1;
        int num = (len + 1) / 2;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < n - 2 * i; j++) {
                x = i;
                y = i + j;
                rotate(matrix,n ,x, y, -1, -1,0);
            }
        }
    }

    /**
     * 43,39,3,33,37,20,14
     * 43,39,3,33,37,20,14
     * 43,39,3,33,37,20,14
     * 43,39,3,33,37,20,14
     * 43,39,3,33,37,20,14
     * 43,39,3,33,37,20,14
     * 43,39,3,33,37,20,14
     *
     */
    public static void rotate(int[][] matrix, int n, int x, int y, int newX, int newY, int lastInt) {

        if (x == newX && y == newY) {
            matrix[x][y] = lastInt;
            return;
        }
        if (newX == -1 && newY == -1) {
            newX = x;
            newY = y;
        }
        int newLastInt   = matrix[newX][newY];
        matrix[newX][newY] = lastInt;
        int newIndexX = newY;
        int newIndexY = n - newX;

        rotate(matrix,n,x,y,newIndexX,newIndexY,newLastInt);

    }

    public static void main(String[] args){
        rotate(new int[][]{{43,39,3,33,37,20,14},{9,18,9,-1,40,22,38},{14,42,3,23,12,14,32},{18,31,45,11,8,-1,31},{28,44,14,23,40,24,13},{29,45,33,45,20,0,45},{12,23,35,32,22,39,8}});
    }
}
