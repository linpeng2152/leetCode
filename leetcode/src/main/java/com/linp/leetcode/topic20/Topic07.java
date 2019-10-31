package com.linp.leetcode.topic20;


/**
 * created by : linpeng
 * ON 2019-10-30 09:41
 * used for:
 */

public class Topic07 {

    public static void main(String[] str){

        int i = 1534236469;
        System.out.println(reverse(1534236469));
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * 在真实的面试中遇到过这道题？
     *
     * 是
     *
     * 否
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int reverse(int x) {
        Integer integer = x;
        String s = integer.toString();
        String reverseStr = null;
        if("-".equals(s.charAt(0))){
            reverseStr= "-" + new StringBuffer(s.substring(1)).reverse().toString();
        }else{
            reverseStr= new StringBuffer(s).reverse().toString();
        }
       return Long.valueOf(reverseStr).intValue();
    }



}
