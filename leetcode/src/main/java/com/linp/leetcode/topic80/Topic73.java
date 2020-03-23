package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-19 13:42
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic73 {


    public static void main(String[] args){
        int[][] s = new int[][]{{1,1,1},{1,0,1},{1,1,1}};

        setZeroes(s);
        System.out.println(s);

    }


    /**
     *
     * 用 两个 list 分别记录 位置 值是  0 的 位置 i，j
     *
     * 编辑 list  对  i，j 位置上进行处理
     * 横向 和 竖向的 位置遍历出来 设置为 0
     *
     */
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> listX = new ArrayList<Integer>();
        List<Integer> listY = new ArrayList<Integer>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int v = matrix[i][j];
                if(v == 0){
                    listX.add(i);
                    listY.add(j);
                }
            }
        }

        for(int i = 0; i < listX.size(); i++){
            setZeroes(matrix,listX.get(i),listY.get(i));
        }

    }

    public static void setZeroes(int[][] matrix,int i,int j) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int x = 0;x < m;x++){
            matrix[x][j] = 0;
        }
        for(int y = 0;y < n;y++){
            matrix[i][y] = 0;
        }

    }


}
