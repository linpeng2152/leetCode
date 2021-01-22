//package com.linp.leetcode.topic200;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @Author : linpeng
// * ON 2020-12-07
// * used for:
// */
//public class Topic188 {
//
//    /**
//     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
//     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//     * 示例 1：
//     * 输入：k = 2, prices = [2,4,1]
//     * 输出：2
//     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
//     * 示例 2：
//     * 输入：k = 2, prices = [3,2,6,5,0,3]
//     * 输出：7
//     * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
//     * 提示：
//     * 0 <= k <= 109
//     * 0 <= prices.length <= 1000
//     * 0 <= prices[i] <= 1000
//     * 通过次数37,841提交次数122,693
//     * 在真实的面试中遇到过这道题？
//     * 是
//     * 否
//     * 来源：力扣（LeetCode）
//     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
//     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//     */
//    public static int maxProfit(int k, int[] prices) {
//        List<Integer> l = new ArrayList<>();
//
//        for(int i = 0;i<prices.length-1;){
//            int temp = 0;
//            int curJ = i + 1;
//            for (int j = i+1;j<prices.length;j++){
//                if(prices[i]>=prices[j]){
//                    i++;
//                    break;
//                }
//                if(prices[j] -prices[i] >= temp){
//                    curJ = j;
//                    temp = prices[j] -prices[i];
//                }
//                if(prices[j] -prices[i] < temp || j == prices.length-1) {
//                    i = curJ;
//                    break;
//                }
//            }
//            if(temp > 0) l.add(temp);
//        }
//        int[] arr = new int[l.size()];
//       for(int i =0;i<l.size();i++){
//           arr[i] = l.get(i);
//       }
//        Arrays.sort(arr);
//       int temp = 0;
//        for(int i = 0;i < l.size() && i < k;i++){
//            temp += arr[l.size() -1- i] ;
//        }
//
//        return temp;
//    }
//
//    /**
//     * 没有解决 和购买次数导致的问题、只能说是在无限购买次数的情况下 是最优解
//     * @param args
//     */
//    public static void main(String[] args){
//        int k = 2;
//        int[] prices = {1,2,4,2,5,7,2,4,9,0};
//
//        System.out.println(maxProfit(k,prices));
//    }
//}
