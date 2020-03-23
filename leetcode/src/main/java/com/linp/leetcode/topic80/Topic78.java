package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-19 17:01
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic78 {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        subsets(nums);
    }

    /**
     * 取不同的长度 k
     *
     *
     *
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        all.add(new ArrayList<>());
        int len = nums.length;
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> item = combine(nums,len,i+1);
            all.addAll(item);
        }
        return all;
    }

    /**
     *
     * @param nums
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int[] nums,int n, int k) {
        List<List<Integer>> all = new ArrayList<>();
        inst(nums,all,new ArrayList(),n,k,0,0);
        return all;
    }


    /**
     * 递归增加 数字
     * 当 list = 所要数目 时 则添加到列表
     *
     */
    public static void inst(int[] nums ,List<List<Integer>> all,List<Integer> item ,int n,int k,int index,int val) {
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
            newItem.add(nums[val-1]);
            inst(nums,all,newItem,n,k,index + 1,val);
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
