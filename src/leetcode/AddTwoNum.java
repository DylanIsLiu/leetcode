package leetcode;

import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 思路：两个链表的每个节点从头到尾依次相加 形成新的链表的节点值 进位则加1到下一节点上
 *
 * @author Liumz
 * @since 2019-04-12  13:55:51
 */
public class AddTwoNum {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode returnList = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curNode = returnList;
        int up = 0;
        while (p1 != null || p2 != null) {
            int l1v = 0;
            int l2v = 0;
            if (p1 != null) {
                l1v = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                l2v = p2.val;
                p2 = p2.next;
            }

            int sum = l1v + l2v + up;
            up = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
        }
        if (up > 0) {
            curNode.next = new ListNode(up);
        }
        return returnList.next;
    }

    public static void main(String[] args) {
    }
}
