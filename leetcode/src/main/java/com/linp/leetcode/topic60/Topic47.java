package com.linp.leetcode.topic60;


import java.util.ArrayList;
import java.util.List;

/**
 * created by : linpeng
 * ON 2019-11-13 14:13
 * used for:
 */

public class Topic47 {


    public static StringBuilder sbb = new StringBuilder();

    /**
     * 做法
     * 1、讲数组转化为 list
     * 2、每次从List取出一个 塞入另一个list
     * 3、直到 剩余list 为空
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<String> strList = new ArrayList<>();
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> surplus = new ArrayList<Integer>(nums.length);
        for(int i: nums){
            surplus.add(i);
        }

        addInt(new ArrayList<Integer>(),surplus,all,strList);

        return all;
    }


    /**
     * 思路
     * 从数组长度 为1 判断并塞入 并返回
     * 两个时 则 循环 取一个 再次执行该方法
     * 三个时 则 循环 取一个 再次执行该方法
     * 依次执行
     *
     */
    public static void addInt(List<Integer> item,List<Integer> surplus,List<List<Integer>> all,List<String> strList){
        if(surplus.size() == 1){
            item.add(surplus.get(0));
            checkAdd(all,item,strList);
            return;
        }
        for(Integer s : surplus){
            List<Integer> newSurplus = surplus(surplus,s);
            List<Integer> newItem = copy(item);
            newItem.add(s);
            addInt(newItem,newSurplus,all,strList);
        }

    }


    public static void checkAdd(List<List<Integer>> all,List<Integer> item,List<String> strList){

        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        for(Integer i : item){
            sb1.append(i.toString());
        }
        sb1.append("]");

        if(! strList.contains(sb1.toString())){
            all.add(item);
            strList.add(sb1.toString());
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
        boolean remove = false;
        List<Integer> newItem = new ArrayList<>(surplus.size());
        for(Integer i:surplus){
            if(i == s && !remove){
                remove = true;
                continue;
            }
             newItem.add(i);
        }
        return newItem;
    }

    public static void main(String[] args){

        long f = System.currentTimeMillis();
        System.out.println(f);
        permuteUnique(new int[]{-1,2,-1,2,1,-1,2,1});
        System.out.println(System.currentTimeMillis() - f);

    }




}
