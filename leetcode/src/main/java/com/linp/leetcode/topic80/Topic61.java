package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-10 16:06
 * used for:
 */

import com.linp.leetcode.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic61 {


    /**
     * 第一步、算出需要循环的次数。K 对长度 取余 就是需要循环的次数
     * 第二步、循环依次的 将 最后一个 移动到 第一个
     */
    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int len = getLen(head);
        k = k % len;

        for (int i = 0; i < k; i++) {
            head = rotateRightOne(head);
        }
        return head;
    }


    /**
     * 找出 最后一个、倒数第二个
     * 最后一个的 next 设置为 老的第一个
     * 倒数第二个的 next 设置为 null
     */
    public static ListNode rotateRightOne(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oldLast = head;
        ListNode newLast = head;
        ListNode cur = head;
        while (cur.next != null) {
            newLast = cur;
            oldLast = cur.next;
            cur = cur.next;
        }
        newLast.next = null;
        oldLast.next = head;
        return oldLast;
    }


    public static int getLen(ListNode head) {
        int len = 1;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        return len;
    }


    public static void main(String[] args) {
        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(3);
        ListNode v4 = new ListNode(4);
        ListNode v5 = new ListNode(5);
        v1.next = v2;
        v2.next = v3;
        v3.next = v4;
        v4.next = v5;


        getLen(v1);

        System.out.println(v1.toString());


        System.out.println(rotateRight(v1, 2).toString());


    }
}
