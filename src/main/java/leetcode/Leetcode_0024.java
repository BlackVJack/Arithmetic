package leetcode;

/**
 * author: BlackVJack/Justice
 * time:2023/7/25 22:47
 *
 * 力扣题库第0024题 两两交换链表的节点
 */
public class Leetcode_0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = p2.next;
        ListNode p4;
        ListNode result = p2;

        p1.next = p3;
        p2.next = p1;

        if (p3 == null || p3.next == null) return result;
        p2 = p3;
        p3 = p3.next;
        p4 = p3.next;
        while (true) {
            p3.next = p2;
            p2.next = p4;
            p1.next = p3;

            if (p4 == null || p4.next == null) break;
            p1 = p2;
            p2 = p4;
            p3 = p2.next;
            p4 = p3.next;
        }
        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
