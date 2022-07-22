// 1ms. 너무 복잡하게 풀었다. 스택 써도 되긴 하는데 정해는 스택 없이 잘 찾아서 이어 붙이는거임.
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftSide = null;
        ListNode newTail = null;
        Stack<ListNode> stack = new Stack<>();
        int index = 1;
        while (head != null) {
            if (index != left) {
                if (leftSide == null) {
                    leftSide = head;
                    newTail = head;
                } else {
                    newTail.next = head;
                    newTail = newTail.next;
                }
                head = head.next;
                index++;
            } else {
                while (index != right) {
                    ListNode temp = head.next;
                    head.next = null;
                    stack.push(head);
                    head = temp;
                    index++;
                }
                ListNode tail = head.next;
                head.next = null;
                stack.push(head);
                if (leftSide == null) {
                    leftSide = stack.pop();
                    newTail = leftSide;
                }
                while (!stack.isEmpty()) {
                    newTail.next = stack.pop();
                    newTail = newTail.next;
                }
                newTail.next = tail;
                break;
            }
        }
        return leftSide;
    }
}
