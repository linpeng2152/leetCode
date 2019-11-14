//package com.linp.leetcode.topic60;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * created by : linpeng
// * ON 2019-11-08 16:12
// * used for:
// */
//
//public class Topic44_1 {
//    /**
//     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//     * <p>
//     * '?' 可以匹配任何单个字符。
//     * '*' 可以匹配任意字符串（包括空字符串）。
//     * 两个字符串完全匹配才算匹配成功。
//     * <p>
//     * 说明:
//     * <p>
//     * s 可能为空，且只包含从 a-z 的小写字母。
//     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
//     * 示例 1:
//     * <p>
//     * 输入:
//     * s = "aa"
//     * p = "a"
//     * 输出: false
//     * 解释: "a" 无法匹配 "aa" 整个字符串。
//     * 示例 2:
//     * <p>
//     * 输入:
//     * s = "aa"
//     * p = "*"
//     * 输出: true
//     * 解释: '*' 可以匹配任意字符串。
//     * 示例 3:
//     * <p>
//     * 输入:
//     * s = "cb"
//     * p = "?a"
//     * 输出: false
//     * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
//     * 示例 4:
//     * <p>
//     * 输入:
//     * s = "adceb"
//     * p = "*a*b"
//     * 输出: true
//     * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
//     * 示例 5:
//     * <p>
//     * 输入:
//     * s = "acdcb"
//     * p = "a*c?b"
//     * 输入: false
//     * <p>
//     * 来源：力扣（LeetCode）
//     * 链接：https://leetcode-cn.com/problems/wildcard-matching
//     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//     *
//     * @param s
//     * @param p
//     * @return
//     */
//    public static boolean isMatch(String s, String p) {
//        boolean isTrue = false;
//
//
//
//        char[] pArr = p.toCharArray();
//        List<Character> pList = new ArrayList<>();
//        char lastChar='.';
//
//        List<String> pp = new ArrayList();
//        StringBuilder sb = new StringBuilder();
//        for (char c : pArr) {
//            if(c=='*' || c == '?'){
//                if(sb.length() !=0){
//                    pp.add(sb.toString());
//                    sb = new StringBuilder();
//                }
//            }else{
//                    sb.append(String.valueOf(c));
//            }
//            if(c == '*' && lastChar =='*'){
//                continue;
//            }
//            pList.add(c);
//            lastChar = c;
//        }
//        if(sb.length() !=0){
//            pp.add(sb.toString());
//        }
//
//        String sub = s;
//        for(String str:pp){
//            if(!sub.contains(str)){
//                return false;
//            }
//            int inx = sub.indexOf(str);
//            if(inx < 0){
//                return false;
//            }
//            sub = sub.substring(inx).replaceFirst(str,"");
//        }
//
//
//
//        return checkMatch(s,pList);
//    }
//
//    public static boolean checkMatch(String s,String){
//
//    }
//
//
//
//
//
//
//    public static boolean checkMatch(List<Character> sList, List<Character> pList) {
//        if (sList.size() == 0 && pList.size() == 0) {
//            return true;
//        }
//
//        if (pList.size() == 1 && pList.get(0) == '*') {
//            return true;
//        }
//        if (pList.size() == 0) {
//            if (sList.size() != 0) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//        if (sList.size() == 0 && pList.size() != 0) {
//            return false;
//        }
//
//        char pFirst = pList.get(0);
//        char sFirst = sList.get(0);
//        if (pFirst == sFirst || pFirst == '?') {
//            sList = geNewList(sList,1);
//            pList = geNewList(pList,1);
//            return checkMatch(sList, pList);
//        } else if (pFirst == '*') {
//            char pNext = pList.get(1);
//
//            if(pNext == '*'){
//                pList = geNewList(pList,2);
//            }else{
//                pList = geNewList(pList,1);
//            }
//            return getAllList(sList,pNext,pList);
//        }
//        return false;
//    }
//
//
//
//
//
//    public static boolean getAllList(List<Character> list,Character c,List<Character> pList){
//
//        for (int i = 0; i <list.size() ;i++) {
//            if(c == list.get(i) || c =='?'){
//                if(checkMatch(geNewList(list,i), pList)){
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//
//    public static List<Character> geNewList(List<Character> list,int start){
//       return new ArrayList(list.subList(start,list.size()));
//    }
//
//
//    public static void main(String[] args) {
//
//        Long t = System.currentTimeMillis();
//        System.out.println(t);
//        System.out.println( isMatch("baaabbabbbaabbbbbbabbbaaabbaabbbbbaaaabbbbbabaaaaabbabbaabaaababaabaaabaaaabbabbbaabbbbbaababbbabaaabaabaaabbbaababaaabaaabaaaabbabaabbbabababbbbabbaaababbabbaabbaabbbbabaaabbababbabababbaabaabbaaabbba"
//               , "*b*ab*bb***abba*a**ab***b*aaa*a*b****a*b*bb**b**ab*ba**bb*bb*baab****bab*bbb**a*a*aab*b****b**ba**abba"
//                ));
//
//        System.out.println(System.currentTimeMillis() - t);
//
//
//    }
//
//}
