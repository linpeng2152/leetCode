package com.linp.leetcode.topic40;


/**
 * created by : linpeng
 * ON 2019-11-01 18:22
 * used for:
 */

import com.linp.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 在真实的面试中遇到过这道题？
 *
 * 是
 *
 * 否
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic24 {

    public static ListNode swapPairs(ListNode head) {



        ListNode cur1=null;
        ListNode cur2=null;
        ListNode first = null;
        ListNode itemFirst = null;
        ListNode item = null;
        boolean needSwap = false;


        while(head != null) {
            item = head;
            head = head.next;
            if(needSwap){
                cur2 = item;

                itemFirst =    changeNode(itemFirst,cur1,cur2);
                if(first == null){
                    first = cur2;
                }


            }else{
                cur1 = item;
            }
            needSwap = !needSwap;
        }



        return  first;
    }


    public static ListNode changeNode(ListNode head,ListNode f1,ListNode f2){
        if(f2== null){
            return f1;
        }
        f1.next = f2.next;
        f2.next = f1;

        if(head != null){
            head.next = f2;
        }
        return f1;
    }


    public static void main(String[] args) {
        ListNode f1 = new ListNode(1);
        ListNode f2 = new ListNode(2);
        ListNode f3 = new ListNode(3);
//        ListNode f4 = new ListNode(4);
        f1.next=f2;
        f2.next=f3;
//        f3.next=f4;

        swapPairs(f1);

    }

}
