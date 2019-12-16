package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-12 10:53
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic67 {


    /**
     * 将 a、b 转为 数组
     * 循环 对数组的 每个每一个元素 相加
     */
    public static String addBinary(String a, String b) {

        int temp = 0;

        List<Integer> l = new ArrayList<>();
        String c = a.length() >= b.length() ? a : b;;
        String d = a.length() < b.length() ? a : b;;
        for(int i = 0 ; i < c.length() ; i++){
            Character f = c.charAt(c.length()-1 - i);
            Character g = '0';
            if(d.length()-1 - i >= 0){
                g = d.charAt(d.length()-1 - i);
            }
            Integer fi = Integer.valueOf(f.toString());
            Integer gi = Integer.valueOf(g.toString());
            int h = fi + gi + temp;
            if(h == 2 ){
                temp = 1;
                h = 0;
            }else if(h ==3){
                temp = 1;
                h = 1;
            }else {
                temp = 0;
            }


            l.add(h);
        }
        if(temp == 1){
            l.add(temp);
        }
        String s = "";
        for(Integer i : l){
            s = i.toString() + s;
        }
        return s;
    }

    public static void main(String[] args){
        System.out.println(addBinary("1011","1010"));
    }

}
