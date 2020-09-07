package com.linp.study.leet.linked;


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

    public  static ListNode line(int ... nums){


        ListNode first = new ListNode(nums[0]);
        ListNode cur = first;

        for(int i = 1;i<nums.length;i++){
            ListNode item = new ListNode(nums[i]);
            cur.next =  item;
            cur = item;

        }

        return first;


    }


    public static  void print(ListNode node){
        for(;;){
            if(node != null ){
                System.out.print(" > " + node.val);
                node = node.next;
            }else {
                break;
            }
        }
        System.out.println();

    }
}
