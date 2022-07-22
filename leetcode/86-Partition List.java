// 2ms. 혼란을 줄이기 위해 노드를 새로 만들어서 붙였는데 그냥 기존 노드 잘 이어도 되긴 함.
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode minHead = null;
        ListNode maxHead = null;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                if (minHead == null) {
                    minHead = new ListNode(curr.val);
                } else {
                    append(minHead, curr.val);
                }
            } else {
                if (maxHead == null) {
                    maxHead = new ListNode(curr.val);
                } else {
                    append(maxHead, curr.val);
                }
            }
            curr = curr.next;
        }

        curr = minHead;
        if (curr == null) {
            return maxHead;
        }
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = maxHead;
        return minHead;
    }

    private void append(ListNode head, int val) {
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(val);
    }
}
