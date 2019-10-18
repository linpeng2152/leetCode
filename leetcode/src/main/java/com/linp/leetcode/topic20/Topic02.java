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
        int num1 = 0;
        ListNode cur = l1;
        num1 += cur.val;
        int x = 1;
        while(cur.next != null){
            x = 10*x;
            cur = cur.next;
            num1 += x*cur.val;
        }

        int num2 = 0;
        cur = l2;
        num2 += cur.val;
         x = 1;
        while(cur.next != null){
            x = 10*x;
            cur = cur.next;
            num2 += x*cur.val;
        }
        int num3 = num1 + num2;//807



        String s =new Integer(num3).toString();
        cur = null;
        ListNode first = null;
        for(int i  = 0;i< s.length(); i++){
            String ite = String.valueOf(s.charAt(i));
            Long val = Long.valueOf(ite);
            ListNode item = new ListNode(val.intValue());
            if(cur == null){
                cur=item;
                first =item;
            }else{
                item.next = cur;
                cur = item;
            }

        }

        return cur;
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
        System.out.println(result.val + " " + result.next.val + "  " + result.next.next.val);

    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}
