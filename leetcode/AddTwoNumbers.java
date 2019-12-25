/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(l1.val);
        ListNode curr = result;
        while (l1.next != null) {
            l1 = l1.next;
            curr.next = new ListNode(l1.val);
            curr = curr.next;
        }
        curr = result;
        boolean plus = false;
        while (curr != null) {
            int currVal = curr.val;
            if (plus) {
                currVal += 1;
            }
            if (l2 != null) {
                currVal += l2.val;
                l2 = l2.next;
            }
            plus = (currVal >= 10);
            if (plus) {
                currVal -= 10;
            }
            curr.val = currVal;
            if (curr.next == null && (l2 != null || plus)) {
                curr.next = new ListNode(0);
            }
            curr = curr.next;
        }

        return result;
    }
}