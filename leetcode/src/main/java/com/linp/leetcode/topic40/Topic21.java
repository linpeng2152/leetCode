package com.linp.leetcode.topic40;


/**
 * created by : linpeng
 * ON 2019-10-31 13:50
 * used for:
 */

import java.util.List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }if(l1 == null ){
            return l2;
        } else if(l2 == null){
            return l1;
        }


        ListNode first = l1.val <= l2.val ? l1 : l2;
        ListNode newl2 = l1.val <= l2.val ? l2 : l1;

        getMini(first,first.next,newl2);

        return first;
    }

    public static void getMini(ListNode first,ListNode l1, ListNode l2){
        ListNode item;
        if(l1==null && l2==null){
            return;
        }if(l1 == null ){
            item = l2;
            first.next = item;

            return;
        } else if(l2 == null){
            item = l1;
            first.next = item;

            return;
        }else{
            item =  l1.val <= l2.val ? l1 : l2;
            first.next = item;
            l2 =  l1.val > l2.val ? l1 : l2;

            getMini(item,item.next,l2);

        }



    }



    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
}
