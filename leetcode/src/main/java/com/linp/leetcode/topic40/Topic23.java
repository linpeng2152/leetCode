package com.linp.leetcode.topic40;


import com.linp.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by : linpeng
 * ON 2019-11-01 15:31
 * used for:
 */

public class Topic23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> l = Arrays.stream(lists).filter(item -> item !=null).collect(Collectors.toList());


        ListNode  first = mergeKListsOne(l);
        mergeKListsOne(first,l);
        return first;
    }

    public static void mergeKListsOne(ListNode first,List<ListNode> lists){
        ListNode  one = mergeKListsOne(lists);
        if(one == null){
            return;
        }
        first.next = one;
        mergeKListsOne(one,lists);
    }

    public static ListNode mergeKListsOne(List<ListNode> lists) {
        ListNode one = null;
        if(lists.size() == 0){
            return null;
        }

        Iterator<ListNode> iter = lists.iterator();
        while (iter.hasNext()) {

            ListNode item = iter.next();
            if (one == null || one.val >= item.val) {
                one = item;


            }
        }
        if(one == null){
            return null;
        }
        lists.remove(one);
        if(one.next != null){
            lists.add(one.next);
        }

        return one;

    }


    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode f1 = new ListNode(1);
        ListNode f2 = new ListNode(4);
        ListNode f3 = new ListNode(5);
        f1.next=f2;
        f2.next=f3;
        ListNode f21 = new ListNode(1);
        ListNode f22 = new ListNode(3);
        ListNode f23 = new ListNode(4);
        f21.next=f22;
        f22.next=f23;
        ListNode f31 = new ListNode(2);
        ListNode f32 = new ListNode(6);
        f31.next=f32;

        mergeKLists(new ListNode[]{f1,f21,f31});


    }
}
