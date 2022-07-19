// 0ms. IDE 없이 풀어봤는데 컴파일 오류 진짜 조심해야한다는걸 느낌...
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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode singleNode = head;
        ListNode doubleNode = head;
        while (doubleNode.next != null && doubleNode.next.next != null) {
            singleNode = singleNode.next;
            doubleNode = doubleNode.next.next;
            if (singleNode.equals(doubleNode)) {
                return true;
            }
        }
        return false;
    }
}
