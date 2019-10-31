package com.linp.leetcode.topic20;


/**
 * created by : linpeng
 * ON 2019-10-17 18:08
 * used for:
 */

public class Topic02 {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *
     * 实例 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = null;
        ListNode next = null;
        ListNode first=null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        int n1,n2,val;
        int x=0;
        while(cur1 != null || cur2 != null || x != 0) {
            n1 = (cur1 == null) ?  0 : cur1.val;
            n2 = (cur2 == null) ? 0 : cur2.val;
            int y = n1 + n2 + x ;
            if( y >= 10){
                x = 1;
                y = y - 10;
            }else{
                x= 0;
            }

            if(first == null){
                cur = new ListNode(y);
                first = cur;
            }else{
                next = new ListNode(y);
                cur.next = next;
                cur = next;
            }

            cur1 = (cur1 == null) ?  null :cur1.next;
            cur2 = (cur2 == null) ?  null :cur2.next;

        }


        return first;
    }

    public static void main(String[] args){
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        ListNode l11 = new ListNode(2);
//        ListNode l12 = new ListNode(4);
        ListNode l11 = new ListNode(9);
//        l11.next = l12;
//        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        l21.next = l22;
        l22.next = l23;

        ListNode result = addTwoNumbers(l11,l21);
        do {
            System.out.print(result.val + "   ");

        }while((result = result.next) != null );


    }

    static class ListNode {
      public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
  }

}
