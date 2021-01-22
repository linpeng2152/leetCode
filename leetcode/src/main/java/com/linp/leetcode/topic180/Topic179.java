package com.linp.leetcode.topic180;

import java.util.*;

/**
 * @Author : linpeng
 * ON 2020-04-13
 * used for:
 */
public class Topic179 {


    public static void main(String[] arg){

//        int[] arr = {111311, 1113};
        int[] arr = {3,30,34,5,9};
//        int[] arr = {432,43243};

        System.out.println(largestNumber(arr));
    }

    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [10,2]
     * 输出: 210
     * 示例 2:
     * <p>
     * 输入: [3,30,34,5,9]
     * 输出: 9534330
     * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * <p>
     * 通过次数27,091提交次数75,431
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        if(nums.length == 0){
            return "0";
        }
        List<Integer> l = new ArrayList<>(nums.length);
        for(int i:nums){
            l.add(i);
        }

        String str = "";
        for (int i = 9; i >= 0; i--) {
            if(i == 0 && str.length() == 0){
                return "0";
            }
            str +=  getNextIndex(l, "" + i);

        }

        return str;
    }


    public static String getNextIndex(List<Integer> l, String f) {
        List<Integer> item = new ArrayList<>();
        for (Integer i:l ) {
            if(i.toString().startsWith(f)){
                item.add(i);
            }
        }
        if(item.isEmpty()){
            return "";
        }
        Integer[] arr = new Integer[item.size()];
        for(int  i =0;i< item.size();i++){
            arr[i] = item.get(i);
        }
        Arrays.sort(arr,new ComparatorX());

        String itemStr = "";
        for(Integer i : arr){
            itemStr += i.toString();
        }
        return itemStr;
    }


    public static class ComparatorX implements Comparator<Integer> {

        public int compare(Integer o1, Integer o2) {
            if (o1.toString().length() == o2.toString().length()) {
                return o2 - o1;
            }else {
                return  compare2(o1,o2);
            }
        }

        public int compare2(Integer o1, Integer o2){

            long o1x = o1 * (long)Math.pow(10.0,o2.toString().length()) + o2;
            long o2x = o2 * (long) Math.pow(10.0,o1.toString().length()) + o1;
            int i = (int)(o2x - o1x);
            System.out.println(o1 + " 和  " + o2 + "  比较结果  " + i);

            return i;

        }
    }


}
