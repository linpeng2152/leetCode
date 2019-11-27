package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-27 11:10
 * used for:
 */

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic58 {
    /**
     * 1、用 ' '切分成数组
     * 2、取最后一字符串的长度
     */
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String[] arr = s.split(" ");
        if (arr.length == 0) {
            return 0;
        }

        return arr[arr.length - 1].length();
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("Hello World"));
    }

}
