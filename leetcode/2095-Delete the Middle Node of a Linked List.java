// 4ms. 각 케이스별로 어떻게 할지 고민하면 쉬움
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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            head.next = null;
            return head;
        }
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast.next == null) {
                prev.next = prev.next.next;
                break;
            }
            if (fast.next.next == null) {
                slow.next = slow.next.next;
                break;
            }
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return head;
    }
}
