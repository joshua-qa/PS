import java.util.HashSet;
import java.util.Set;

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        ListNode prev = head;
        ListNode curr = head;
        while (curr != null) {
            if (prev == curr) {
                curr = curr.next;
                continue;
            }
            if (numSet.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = prev.next;
        }
        if (numSet.contains(head.val)) {
            head = head.next;
        }
        return head;
    }
}
