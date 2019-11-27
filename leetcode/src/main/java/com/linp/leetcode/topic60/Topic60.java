package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-26 16:21
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic60 {

    /**
     * 1、第一步获取到数组字符串
     * 2、从老的字符移动到新的字符
     * 3、当老的字符串为空时、添加到列表
     * 4、当列表长度等于返回的时 就直接结束循环
     * 5、主要时递归的取得 字符串
     */
    public static String getPermutation(int n, int k) {
        List<String> l = new ArrayList<>();

        String oldStr = "";
        for(int i =1;i<=n;i++) {
            oldStr += i;
        }
        ad("",oldStr,l,k);
        return l.get(k-1);
    }

    public static void ad(String lastStr,String oldStr,List<String> l,int k){
        if(oldStr.length() <= 1){
           l.add(lastStr + oldStr);
           return;
        }
        for(int i=0;i<oldStr.length();i++){
            if(l.size() == k){
                return;
            }
            String newLastStr = new String(lastStr.toCharArray());
            newLastStr += oldStr.charAt(i);
            String newOldStr = new StringBuilder(oldStr).deleteCharAt(i).toString();
            ad(newLastStr,newOldStr,l,k);
        }
    }

    public static void main(String[] args) {


        System.out.println(getPermutation(3,3));

    }

}
