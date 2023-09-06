package leetcode;

/**
 * author: BlackVJack/Justice
 * time:2023/7/26 22:44
 *
 * 力扣题库第0025题
 */
public class Leetcode_0025 {
    static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    /**
     * 题目描述
     * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     *  示例1
     *      输入：head = [1,2,3,4,5], k = 2
     *      输出：[2,1,4,3,5]
     *
     *  示例2
     *      输入：head = [1,2,3,4,5], k = 3
     *      输出：[3,2,1,4,5]
     */

    public static void main(String[] args) {

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        ListNode pr = head;
        ListNode[] array = new ListNode[5000];

        int length = 0;
         while (pr != null) {
            array[length++] = pr;
            pr = pr.next;
        }

        for (int i, j = 0; j < length; j++) {
            i = j;
            int l = i + k - 1;
            if(l > length - 1) break;
            while (i < l) {
                swap(array, i++, l--);
                j += (i <= l ? 2 : 1);
            }
        }
        for (int i = 0; i < length - 1; i++) {
            array[i].next = array[i + 1];
        }
        array[length - 1].next = null;
        return array[0];
    }

    public void swap(ListNode[] array, int i, int j) {
        ListNode temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
