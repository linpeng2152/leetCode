package com.linp.leetcode.topic100;


/**
 * created by : linpeng
 * ON 2019-12-20 19:46
 * used for:
 */

import com.linp.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic86 {


    public static void main(String[] args) {
        ListNode f1 = new ListNode(1);
        ListNode f2 = new ListNode(4);
        ListNode f3 = new ListNode(3);
        ListNode f4 = new ListNode(2);
        ListNode f5 = new ListNode(5);
        ListNode f6 = new ListNode(2);
        f1.next = f2;
        f2.next = f3;
        f3.next=f4;
        f4.next=f5;
        f5.next=f6;

        partition(f1,1);

    }

    //不理解  感觉已经解出来了  为什么 【 2，1】 1  需要返回 【2，1】 而不是 【1，2】
    public static ListNode partition(ListNode head, int x) {

        int i = Integer.MIN_VALUE;
        ListNode first = head;

        while(head != null){
            if(x == 0){
                i = head.val;
            }
            x--;
            head = head.next;
        }
        List<ListNode> min = new ArrayList<>();
        List<ListNode> max = new ArrayList<>();

        while(first != null){
            if(first.val <= i){
                min.add(first);
            }else{
                max.add(first);
            }
            first = first.next;
        }
        first = null;
        ListNode cur = null;
        for(ListNode s:min){
            s.next =  null;
            if(first == null ){
                first = s;
                cur = s;
                continue;
            }
            cur.next = s;
            cur = s;
        }
        for(ListNode s:max){
            s.next =  null;
            if(first == null){
                first = s;
                cur = s;
                continue;
            }
            cur.next = s;
            cur = s;
        }

        return first;

    }
}
