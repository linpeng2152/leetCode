package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-12 10:25
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic66 {

    public static int[] plusOne(int[] digits) {

        List<Integer>  d = new ArrayList<Integer>();
        int temp = 1;

        for(int i = digits.length-1; i >= 0 ; i--){
            int v = digits[i];
            v += temp;
            if(v == 10){
                v = 0;
                temp = 1;
            }else{
                temp = 0;
            }
            d.add(0,v);
        }
        if(temp == 1){
            d.add(0,temp);
        }

        int[] dd = new int[d.size()];
        for(int i = 0; i < d.size(); i++){
            dd[i] = d.get(i);
        }


        return dd;

    }
    public static void main(String[] args) {

        plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});

    }

}
