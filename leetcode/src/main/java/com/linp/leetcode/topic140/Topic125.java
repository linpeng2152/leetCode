package com.linp.leetcode.topic140;


/**
 * created by : linpeng
 * ON 2020-01-10 15:33
 * used for:
 */

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic125 {


    public static final String f1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public static final String f2 = "abcdefghijklmnopqrstuvwxyz";

    public static  void main(String[] args) throws Exception {
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";

        System.out.println(isPalindrome(s));
    }


    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()){
           if(f1.contains(c.toString()) || f2.contains(c.toString())){
               sb.append(c.toString().toLowerCase());
            }
        }
        int len = sb.length();
        for(int i = 0; i < len;i++){
            if(sb.charAt(i) == sb.charAt(len-i-1)){
                continue;
            }else{
                return false;
            }
        }
        return true;

    }

}
