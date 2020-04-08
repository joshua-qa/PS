public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        System.out.println(middleNode(listNode).val);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode middleNode(ListNode head) {
        ListNode lazy = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            lazy = lazy.next;
            fast = fast.next.next;
        }
        return lazy;
    }
}
