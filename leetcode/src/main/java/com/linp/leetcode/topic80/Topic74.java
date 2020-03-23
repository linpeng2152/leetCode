package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-19 13:57
 * used for:
 */

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic74 {

    /**
     * 找出靠谱的 X
     * 找出靠谱的 X，Y
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0){
            return false;
        }
        int n = matrix[0].length;
        if(n == 0){
            return false;
        }

        int x = 0;
        for(int i = 0; i < m; i++){
            int valMin = matrix[i][0];
            int valMax = matrix[i][n-1];
            if(valMin == target || valMax == target){
                return true;
            }
            if(valMin < target && valMax > target){
                x = i;
                break;
            }

        }

        for(int i = 0; i < n ; i++){
            int val = matrix[x][i];
            if(val == target){
                return true;
            }

        }


        return false;
    }


}
