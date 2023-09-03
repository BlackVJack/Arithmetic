package leetcode;

/**
 * author: BlackVJack/Justice
 * time:2023/7/25 22:47
 */
public class Leetcode_0024 {


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = head.next;
        ListNode pr = head;
        ListNode p = pr.next;
        ListNode node;
        ListNode pre;

        node = p.next;
        pr.next = node;
        p.next = p;

        pre = pr;
        pr = node;
        if (pr == null) return result;
        p = node.next;
        if (p == null) return result;
        node = p.next;
        while (true) {
            pr.next = node;
            p.next = pr;
            pre.next = p;

            pre = pr;
            pr = node;
            if (pr == null) break;
            p = node.next;
            if (p == null) break;
            node = p.next;
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
