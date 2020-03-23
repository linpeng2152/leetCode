package com.linp.leetcode.topic160;

/**
 * created by : linpeng
 * ON 2020-03-20
 * used for:
 */

import com.linp.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 示例 1:

 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 示例 2:

 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 通过次数18,998提交次数34,503
 */
public class Topic143 {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        Map<Integer,ListNode> map = new HashMap<>();
        int n = 0;
        ListNode cur = head;
        while ( cur !=null){
            map.put(n,cur);
            cur = cur.next;
            map.get(n).next = null;
            n ++;

        }

        for(int i = 0;i<n/2;i++){
            if(n-i-1 != i){
                map.get(i).next = map.get(n-i-1 );
            }
            if(n-i-1  != i+1){
                map.get(n-i-1 ).next = map.get(i+1);
            }
            System.out.println(i);
        }
        System.out.println(head);
    }
}