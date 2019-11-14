package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-14 10:57
 * used for:
 */

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic50 {

    /**
     * 超出时间 限制
     */
    public static double myPow(double x, int n) {

        boolean over0 = n > 0 ;

        n = n > 0 ? n : 0-n;

        double temp = 1;
        for(int i = 0; i < n; i++) {
            temp = temp * x;
        }

        if(over0) {
            return temp;
        }else{
           return 1/temp;
        }
    }

    public static void main(String[] args) {

        long  f = System.currentTimeMillis();
        System.out.println(f);
        myPow(0.00001,
                2147483647);
         System.out.println(System.currentTimeMillis() -f);

    }
}
