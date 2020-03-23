package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-19 15:40
 * used for:
 */

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic76 {

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
//        String s2 = "fgcf";
//        String s3 = "cabwe";
//
//        System.out.println(s.substring(0,s.length() - s2.length() + 1));
//        System.out.println(s.substring(s3.length()-1));
        String t = "cae";
        System.out.println(minWindow(s,t));
    }


    public static String minWindow(String s, String t) {
        if(!contains(s,t)){
            return "";
        }
        if(s.length() < t.length()){
            return "";
        }


        String newS1 = cutLeft(s,s,t);
        String newSS1 = cutRight(newS1,newS1,t);


        String newS2 = cutRight(s,s,t);
        String newSS2 = cutLeft(newS2,newS2,t);


        return newSS1.length() < newSS2.length() ? newSS1 : newSS2;
    }

    public static String cutLeft(String firstS,String s,String t) {
        String newS = s.substring(1);
        if(contains(newS,t)){
           return cutLeft(firstS,newS,t);
        }else{
            String leftS = firstS.substring(s.length() - 1 );

            if(contains(leftS,t)){
                String newS2 = minWindow(leftS,t);
                return s.length() < newS2.length() ? s : newS2;

            }

            return s;
        }
    }
    public static String cutRight(String firstS,String s,String t) {
        String newS = s.substring(0,s.length()-1);
        if(contains(newS,t)){
           return cutRight(firstS,newS,t);
        }else{
            String leftS = firstS.substring(0,s.length() - s.length() + 1);
            if(contains(leftS,t)){

                String newS2 = minWindow(leftS,t);
                return s.length() < newS2.length() ? s : newS2;

            }

            return s;
        }
    }


    public static boolean contains(String ns,String t) {
        for(Character c:t.toCharArray()){
           if(! ns.contains(c.toString())){
               return false;
           }
            ns = ns.replaceFirst(c.toString(),"");
        }
        return true;
    }



}
