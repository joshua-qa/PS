// 1ms. extra space O(1)로 하는 법은 잘 보고 배워놔야겠음.
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
    List<TreeNode> nodes;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        nodes = new ArrayList<>();
        preOrder(root);
        TreeNode prev = root;
        for (int i = 1; i < nodes.size(); i++) {
            prev.left = null;
            prev.right = nodes.get(i);
            prev = prev.right;
        }
    }

    private void preOrder(TreeNode curr) {
        if (curr == null) {
            return;
        }
        nodes.add(curr);
        preOrder(curr.left);
        preOrder(curr.right);
    }
}
