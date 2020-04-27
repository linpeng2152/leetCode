package com.linp.leetcode.topic180;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : linpeng
 * ON 2020-04-13
 * used for:
 */
public class Topic171 {


    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     * <p>
     * 例如，
     * <p>
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * 示例 1:
     * <p>
     * 输入: "A"
     * 输出: 1
     * 示例 2:
     * <p>
     * 输入: "AB"
     * 输出: 28
     * 示例 3:
     * <p>
     * 输入: "ZY"
     * 输出: 701
     * 致谢：
     * 特别感谢 @ts 添加此问题并创建所有测试用例。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] ars){
        System.out.println(titleToNumber("ZZZ"));

    }

    public static int titleToNumber(String s) {

        Map<String, Integer> m = new HashMap<>(26);
        m.put("A", 1);
        m.put("B", 2);
        m.put("C", 3);
        m.put("D", 4);
        m.put("E", 5);
        m.put("F", 6);
        m.put("G", 7);
        m.put("H", 8);
        m.put("I", 9);
        m.put("J", 10);
        m.put("K", 11);
        m.put("L", 12);
        m.put("M", 13);
        m.put("N", 14);
        m.put("O", 15);
        m.put("P", 16);
        m.put("Q", 17);
        m.put("R", 18);
        m.put("S", 19);
        m.put("T", 20);
        m.put("U", 21);
        m.put("V", 22);
        m.put("W", 23);
        m.put("X", 24);
        m.put("Y", 25);
        m.put("Z", 26);

        int len = s.length();
        int v = 1;
        int c = 0;
        for (int y = len - 1; y >= 0; y--) {
            System.out.println("" + s.charAt(y));
            c += m.get(s.charAt(y) + "") * v;
            v = v * 26;

        }

        return c;


    }


}
