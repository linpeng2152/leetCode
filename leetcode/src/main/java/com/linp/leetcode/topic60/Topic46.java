package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-13 13:49
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic46 {


    /**
     * 做法
     * 1、讲数组转化为 list
     * 2、每次从List取出一个 塞入另一个list
     * 3、直到 剩余list 为空
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> surplus = new ArrayList<Integer>(nums.length);
        for(int i: nums){
            surplus.add(i);
        }

        addInt(new ArrayList<Integer>(),surplus,all);

        return all;
    }


    /**
     * 思路
     * 从数组长度 为1 则塞入 并返回
     * 两个时 则 循环 取一个 再次执行该方法
     * 三个时 则 循环 取一个 再次执行该方法
     */
    public static void addInt(List<Integer> item,List<Integer> surplus,List<List<Integer>> all){
        if(surplus.size() == 1){
            item.add(surplus.get(0));
            all.add(item);
            return;
        }
        for(Integer s : surplus){
            List<Integer> newSurplus = surplus(surplus,s);
            List<Integer> newItem = copy(item);
            newItem.add(s);
            addInt(newItem,newSurplus,all);
        }

    }

    public static List<Integer>  copy(List<Integer> item){
        List<Integer> newItem = new ArrayList<>(item.size());
        for(Integer i:item){
            newItem.add(i);
        }
        return newItem;
    }


    public static List<Integer>  surplus(List<Integer> surplus,Integer s){
        List<Integer> newItem = new ArrayList<>(surplus.size());
        for(Integer i:surplus){
            if( i != s){
                newItem.add(i);
            }
        }
        return newItem;
    }


    public static void main(String[] args){
        permute(new int[]{1,2,3});

    }
}
