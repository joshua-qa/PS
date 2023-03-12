// 6ms. Heap Sort 짜기 귀찮아서 pq 썼다.
import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            ListNode curr = list;
            while (curr != null) {
                pq.offer(curr);
                curr = curr.next;
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        ListNode head = pq.poll();
        ListNode curr = head;
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
}
