// 0ms. 사이클 찾는 문제랑 함께 책에서 봤던 문제 같은데..
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (fast == null) {
            head = slow.next;
            return head;
        }
        ListNode removeNode = slow.next;
        ListNode afterNext = slow.next.next;
        slow.next = afterNext;
        removeNode = null;
        return head;
    }
}
