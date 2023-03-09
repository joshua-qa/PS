// 4ms. 아마 제대로 풀려면 싸이클 여부 판단하는 문제처럼 fast / slow 만들어서 해야된다.
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private Set<ListNode> count;
    public ListNode detectCycle(ListNode head) {
        count = new HashSet<>();
        while (head != null && !count.contains(head)) {
            count.add(head);
            head = head.next;
        }
        return head;
    }
}
