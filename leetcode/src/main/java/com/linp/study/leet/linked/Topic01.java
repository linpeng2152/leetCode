package com.linp.study.leet.linked;

/**
 * @Author : linpeng
 * ON 2020-08-03
 * used for: 链表的逆序
 * 已知链表头节点指针head，将链表逆序。(不可申请额外空间)
 */
public class Topic01 {
    public static  void main(String[] agrs){
        ListNode head = ListNode.line(1,2,3,4,5,6);
        ListNode.print(head);
        //方法1
        ListNode.print(reverse(head));


    }


    /**
     * 思路
     */
    public static  ListNode reverse(ListNode head){

        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;

    }


}
