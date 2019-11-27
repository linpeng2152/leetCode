//package com.linp.leetcode.topic60;
//
//
///**
// * created by : linpeng
// * ON 2019-11-27 17:58
// * used for:
// */
//
//import java.util.List;
//
///**
// * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
// *
// * 示例 1:
// *
// * 输入:
// * [
// *  [ 1, 2, 3 ],
// *  [ 4, 5, 6 ],
// *  [ 7, 8, 9 ]
// * ]
// * 输出: [1,2,3,6,9,8,7,4,5]
// * 示例 2:
// *
// * 输入:
// * [
// *   [1, 2, 3, 4],
// *   [5, 6, 7, 8],
// *   [9,10,11,12]
// * ]
// * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// * 在真实的面试中遇到过这道题？
// *
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/spiral-matrix
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// */
//public class Topic54 {
//
//
//
//    public static List<Integer> spiralOrder(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//
//
//        int[][] data = new int[n][n];
//        int count = n*n;
//
//        trun(data,1,0,0,1,count,0,m,n);
//
//        return data;
//    }
//
//
//    /**
//     *
//     * 1.将 x,y 位置上设置成对应
//     * 2、计算下一个值是否需要转向
//     * 3、根据当前方向 计算 新的 x，y的值
//     *
//     * 递归调用 直到 所有的数目都设置了
//     */
//    public static void trun(int[][] data,int val,int x,int y,int tag,int count,int circle,int m,int n) {
//        if(count <= 0){
//            return;
//        }
//        int newVal=0, newX=0, newY=0, newTag=0, newCount=circle,newCircle=0;
//        data[x][y] = val;
//        newTag = turnL(x,y, tag, n);
//        if(newTag == 1){
//            newCircle =  ++circle;
//
//        }else if(newTag == -1){
//            newTag = tag;
//        }
//
//
//
//        if(newTag == 1){
//            newX = x;
//            newY = ++y;
//        }else if(newTag ==2){
//            newX = ++x;
//            newY = y;
//        }else if(newTag ==3){
//            newX = x;
//            newY = --y;
//        }else if(newTag ==4){
//            newX = --x;
//            newY = y;
//        }
//
//        newVal = ++val;
//        newCount = --count;
//
//
//        trun(data,newVal, newX, newY, newTag, newCount,newCircle,m,n);
//    }
//
//
//    /**
//     * 判断是否需要转弯
//     * 该规律 需要画图研究
//     */
//    public static int turnL(int x,int y,int tag,int m,int n){
//
//        if(tag == 1){
//            if(x+y == n-1 && x < y){
//                return 2;
//            }
//        }else if(tag ==2){
//            if(x-y == m-n && x >= n/2){
//                return 3;
//            }
//
//        }else if(tag ==3){
//            if(x+y == n-1 && x > y){
//                return 4;
//            }
//
//        }else if(tag ==4){
//            if(x==y+1 && x <= n/2){
//                return 1;
//            }
//
//        }
//        return -1;//代表不用转向
//    }
//}
