import java.util.Queue;

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // count
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        Queue<Integer> splitQueue = new LinkedList<>();
        int div = count / k;
        int mod = count % k;
        for (int i = 0; i < k; i++) {
            if (mod > 0) {
                splitQueue.offer(div + 1);
                mod--;
                continue;
            }
            splitQueue.offer(div);
        }

        // split
        ListNode[] result = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            int insertCount = splitQueue.poll();
            if (insertCount == 0) {
                continue;
            }
            ListNode insertHead = curr;
            ListNode insertCurr = curr;
            for (int j = 1; j < insertCount; j++) {
                insertCurr = insertCurr.next;
            }
            curr = insertCurr.next;
            insertCurr.next = null;
            result[i] = insertHead;
        }

        return result;
    }
}
