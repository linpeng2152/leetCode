package com.linp.leetcode.topic20;


import java.util.ArrayList;
import java.util.List;

/**
 * created by : linpeng
 * ON 2019-10-30 08:40
 * used for:
 */

public class Topic06 {

    public static void main(String[] args) throws Exception {

        String str = "LEETCODEISHIRING";

        System.out.println(convert(str,3));

    }

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * 0 1 2 3 4 5 6 7 8
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * 0 1 2 3 4 5 6
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * 在真实的面试中遇到过这道题？
     *
     * 是
     *
     * 否
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static String convert(String s, int numRows) {
        int len = s.length();


        List<Character[]> list = new ArrayList<Character[]>();


        Character[] cur = null;
        int curIndex = 0;
        for(int i = 0; i < len; i++) {
            Character c = s.charAt(i);

            if(cur == null){
                cur = new Character[numRows];
                list.add(cur);
            }
            if(isFull(curIndex,cur,numRows)){
                cur = new Character[numRows];
                list.add(cur);
                curIndex++;
            }

            inst(c,cur,curIndex,numRows);


        }


        return getLastStr(list,numRows);
    }

    /**
     * * L   C   I   R
     * * E T O E S I I G
     * * E   D   H   N
     * LCIRETOESIIGEDHN
     */
    private static String getLastStr(List<Character[]> list,int numRows){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<numRows;i++){
            for(Character[] cur:list){
                if(cur[i] != null){
                    sb.append(cur[i]);
                }
            }
        }
        return sb.toString();

    }




    private static void inst(Character c, Character[] cur, int curIndex, int numRows) {
        if(curIndex == 0 || ((curIndex) % (numRows-1)) == 0){
            int len = getCharNum(cur);
            cur[len] = c;
        }else{
            int i = numRows - ((curIndex) % (numRows-1));
            cur[i-1] = c;
        }
    }






    public static boolean isFull(int index,Character[] cur,int numRows){
        int len = getCharNum(cur);
        if(index == 0 || ((index) % (numRows-1)) == 0){
            return len == numRows;
        }else{
            return len == 1;
        }
    }

    public static int getCharNum(Character[] cur){
        int num = 0;
        for(Character c : cur){
            if(c != null){
                num ++;
            }
        }
        return num;
    }

}
