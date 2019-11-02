package com.linp.leetcode.topic40;


import com.linp.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by : linpeng
 * ON 2019-11-02 10:00
 * used for:
 */

public class Topic25 {


    /**
     * 超过内存限制
     */
    public static ListNode swapPairs(ListNode head, int k) {

        ListNode cur1 = null;
        ListNode cur2 = null;
        List<ListNode> all = new ArrayList<ListNode>();
        List<ListNode> item = new ArrayList<ListNode>();

        while (head != null) {
            item.add(head);
            head = head.next;
             insert(all, item, k, item.size() == k);
        }
        insert(all, item, k, true);
        int len = all.size();
        cur1 = null;
        cur2 = null;
        for (int j = len - 1; j >= 0; j--) {
            cur2 = all.get(j);
            if (cur1 == null) {
                cur1 = cur2;
            } else {
                cur2.next = cur1;
                cur1 = cur2;
            }
        }

        return cur1;
    }


    public static void insert(List<ListNode> all, List<ListNode> item, int k, boolean needAdd) {
        if(!needAdd){
            return;
        }
        int len = item.size();
        for (int j = len - 1; j >= 0; j--) {
            all.add(item.get(j));
        }
        item.clear();

    }

    public static void main(String[] args) {
        ListNode f1 = new ListNode(1);
        ListNode f2 = new ListNode(2);
        ListNode f3 = new ListNode(3);
        ListNode f4 = new ListNode(4);
        ListNode f5 = new ListNode(5);
        f1.next = f2;
        f2.next = f3;
        f3.next = f4;
        f4.next = f5;

        swapPairs(f1, 3);

    }

}
