// 25ms. O(1) space 도전하러 한번 더 풀 예정
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
    public boolean isPalindrome(ListNode head) {
        // case 1 next가 null -> 홀수 -> 하나 빼고 다음부터 하나씩 보면서 순회
        // case 2 next.next가 null -> 짝수 -> 다음부터 하나씩 보면서 순회
        if (head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null) {
            if (fast.next == null) {
                while (!stack.isEmpty()) {
                    int curr = stack.pop();
                    slow = slow.next;
                    if (curr != slow.val) {
                        return false;
                    }
                }
                return true;
            }

            if (fast.next.next == null) {
                stack.push(slow.val);
                while (!stack.isEmpty()) {
                    int curr = stack.pop();
                    slow = slow.next;
                    if (curr != slow.val) {
                        return false;
                    }
                }
                return true;
            }

            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
