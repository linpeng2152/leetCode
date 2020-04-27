package com.linp.leetcode.topic180;

/**
 * @Author : linpeng
 * ON 2020-04-13
 * used for:
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic168 {

    public static void main(String[] arg){
        System.out.println(convertToTitle(701));
    }


    public static String convertToTitle(int n) {
        Map<Integer,String> m = new HashMap<>(26);
        m.put(0,"");
        m.put(1,"A");
        m.put(2,"B");
        m.put(3,"C");
        m.put(4,"D");
        m.put(5,"E");
        m.put(6,"F");
        m.put(7,"G");
        m.put(8,"H");
        m.put(9,"I");
        m.put(10,"J");
        m.put(11,"K");
        m.put(12,"L");
        m.put(13,"M");
        m.put(14,"N");
        m.put(15,"O");
        m.put(16,"P");
        m.put(17,"Q");
        m.put(18,"R");
        m.put(19,"S");
        m.put(20,"T");
        m.put(21,"U");
        m.put(22,"V");
        m.put(23,"W");
        m.put(24,"X");
        m.put(25,"Y");
        m.put(26,"Z");
        if(n <= 26){
            return  m.get(n);
        }

        int last = n % 26;
        if(last == 0){
            last = 26;
        }
        n = n - last;
        String lastStr = m.get(last);
        String str = "";

        if(n  <= 26){
            str += m.get(n/26);
        }



        while (n > 26){
            if(n  == 26){
                str += "Z";
                break;
            }

            int i = n / 26;
            if(i <= 26){
                str += m.get(i);
            }else{
                str += "Z";

            }
            n = i;

        }
        return str + lastStr;

    }




}
