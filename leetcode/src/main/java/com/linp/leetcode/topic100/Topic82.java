package com.linp.leetcode.topic100;


/**
 * created by : linpeng
 * ON 2019-12-20 10:38
 * used for:
 */

import com.linp.leetcode.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic82 {


    public static void main(String[] args) {
        ListNode f1 = new ListNode(1);
        ListNode f2 = new ListNode(2);
        ListNode f3 = new ListNode(2);
//        ListNode f4 = new ListNode(3);
//        ListNode f5 = new ListNode(4);
//        ListNode f6 = new ListNode(4);
//        ListNode f7 = new ListNode(5);
        f1.next = f2;
        f2.next = f3;
//        f3.next=f4;
//        f4.next=f5;
//        f5.next=f6;
//        f6.next=f7;

        deleteDuplicates(f1);

    }


    /**
     * 用Map 存放映射关系
     * 1、用一个列表 keys  存放当前的key
     * 2、用一个列表 removeKeys 存放已经被删除过的 key
     * 3、当key 重复出现时 keys 删除、removeKeys中添加  当一个key keys中不重复 且在 removeKeys中添加中不存在 则加入 keys
     * 根据 keys 和 map 生成新的 ListNode
     */
    public static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        List<Integer> keys = new ArrayList<>();
        List<Integer> removeKeys = new ArrayList<>();
        while (head != null) {
            int k = head.val;
            if (keys.contains(k)) {
                keys.remove(new Integer(k));
                removeKeys.add(k);
            } else if (!removeKeys.contains(k)) {
                keys.add(k);
                map.put(k, head);
            }
            head = head.next;
        }
        ListNode first = null;
        ListNode cur = null;
        for (Integer k : keys) {
            ListNode val = map.get(k);
            if (first == null) {
                first = val;
                cur = val;
                val.next = null;
            } else {
                cur.next = val;
                cur = val;
                cur.next = null;
            }
        }

        return first;

    }
}
