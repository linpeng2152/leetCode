package com.linp.leetcode.topic140;


/**
 * created by : linpeng
 * ON 2020-01-10 14:41
 * used for:
 */

import java.util.Arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic123 {

    public static void main(String[] args) {
//        int[] arr = {3,3,5,0,0,3,1,4};
        int[] arr = {1,2,4,2,5,7,2,4,9,0};

        System.out.println(maxProfit(arr));
    }


    public static int maxProfit(int[] prices) {


        int m1 = maxProfit1(prices);
        int m2 = maxProfit2(prices);

        return m1 > m2 ? m1 : m2;

    }

    /**
     * 循环
     */
    public static int maxProfit1(int[] prices) {

        if(prices.length <= 2){
            return 0;
        }
        //6,1,3,2,4,7
        int[] arr = new int[prices.length];
        for(int i = 0; i < prices.length-1;){

            int cur = prices[i];
            int curMax = prices[i];
            int x = i+1;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] > curMax) {
                    curMax = prices[j];
                    x = j;
                }else{
                    break;
                }
            }
            if (curMax - cur > 0) {
                arr[i] = curMax - cur;
            }

            i = x;
            continue;
        }
        Arrays.sort(arr);

        return arr[prices.length-1] + arr[prices.length-2];
    }


    /**
     * 循环
     */
    public static int maxProfit2(int[] prices) {
        if(prices.length < 2){
            return 0;
        }

        int[] arr = new int[prices.length];
        for(int i = 0; i < prices.length-1;){

            int f1 = prices[i];
            int f2 = prices[i+1];
            if(f2 <= f1){
                i++;
                continue;
            }
            if(f2 > f1){
                arr[i] =  (f2 - f1);
            }
            i++;
            continue;
        }
        Arrays.sort(arr);

        return arr[prices.length-1] + arr[prices.length-2];

    }
}
