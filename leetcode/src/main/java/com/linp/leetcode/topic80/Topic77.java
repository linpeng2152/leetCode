package com.linp.leetcode.topic80;


import java.util.ArrayList;
import java.util.List;

/**
 * created by : linpeng
 * ON 2019-12-19 15:25
 * used for:
 */

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic77 {
    public static void main(String[] args){
        List<List<Integer>> all = combine(4,2);
        System.out.println(all);
    }


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> all = new ArrayList<>();
        inst(all,new ArrayList(),n,k,0,0);
        return all;
    }


    public static void inst(List<List<Integer>> all,List<Integer> item ,int n,int k,int index,int val) {
        if(index == k ){
            all.add(item);
            return;
        }
        if(val == n){
            return;
        }
        val ++;
        for(;val<=n;val++){
            List<Integer> newItem = copy(item);
            newItem.add(val);
            inst(all,newItem,n,k,index + 1,val);
        }

    }

    public static List<Integer>  copy(List<Integer> item){
        List<Integer> newItem = new ArrayList<>();
        for(Integer i:item){
            newItem.add(i);
        }
        return newItem;
    }

}
