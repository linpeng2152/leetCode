package com.linp.leetcode;


/**
 * created by : linpeng
 * ON 2019-11-01 15:30
 * used for:
 */

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }



    public  String toString(){
        String str = "" + val;


        ListNode cur = this;
        while(cur.next != null){
            cur = cur.next;
            str += " -> " + cur.val;
        }

        return str;
    }

}
