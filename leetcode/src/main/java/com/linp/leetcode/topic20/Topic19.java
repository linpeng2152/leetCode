package com.linp.leetcode.topic20;


/**
 * created by : linpeng
 * ON 2019-10-31 11:49
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic19 {

    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodeList = new ArrayList<>();
        nodeList.add(head);
        while(head.next != null){
            head = head.next;
            nodeList.add(head);
        }

        ListNode delNode = nodeList.get(nodeList.size() - n);
        if(nodeList.size() - n == 0){
            return head.next;
        }
        if(n==0){
            return head;
        }
        ListNode topNode = nodeList.get(nodeList.size() - n-1);

        if(n==1){
            topNode.next = null;
            return head;
        }
        ListNode nextNode = nodeList.get(nodeList.size() - n+1);
        topNode.next = nextNode;
        return head;

    }






    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
}
