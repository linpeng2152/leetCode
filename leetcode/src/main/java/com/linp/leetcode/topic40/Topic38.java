package com.linp.leetcode.topic40;

/**
 * @Author : linpeng
 * ON 2020-10-15
 * used for:
 */
public class Topic38 {

    /**
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
     *
     * 注意：整数序列中的每一项将表示为一个字符串。
     *
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 第一项是数字 1
     *
     * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
     *
     * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
     *
     * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
     *
     * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 1
     * 输出: "1"
     * 解释：这是一个基本样例。
     * 示例 2:
     *
     * 输入: 4
     * 输出: "1211"
     * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-and-say
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] ar){
        System.out.println(countAndSay(5));
//        String s = "1211";
//        System.out.println(getStart(s.toCharArray(),"",0));

    }

    public static String countAndSay(int n) {
        String str = "1";
        for(int i = 0;i<n-1;i++){
            str = getStart(str.toCharArray(),"",0);
        }
        return str;
    }

    public static String getStart(char[] chars,String newStr,int i){
        char c = chars[i];
        int n = -1;
        for(int x = 0 ;x  <chars.length - i;x++){
            if(chars[x+i] != c){
                n = x;
                break;
            }
        }
        if(n==-1){
            n = chars.length - i;
        }

        i = i + n;

        newStr = newStr + "" + n + "" + String.valueOf(c);
        if(i >= chars.length){
            return newStr;
        }
        return getStart(chars,newStr,i);
    }
}
