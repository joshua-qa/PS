// 1ms. 리스트 없이 푸는건 다음번에...
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<TreeNode> treeNodes;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        treeNodes = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            treeNodes.add(new TreeNode(curr.val));
            curr = curr.next;
        }

        return makeTree(0, treeNodes.size()-1);
    }

    private TreeNode makeTree(int start, int end) {
        if (start == end) {
            return treeNodes.get(start);
        }

        int mid = (start + end) / 2;
        TreeNode curr = treeNodes.get(mid);
        if (mid != start) {
            curr.left = makeTree(start, mid-1);
        }
        if (mid != end) {
            curr.right = makeTree(mid+1, end);
        }
        return curr;
    }
}
