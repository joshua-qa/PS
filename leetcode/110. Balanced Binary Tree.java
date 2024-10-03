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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || (int) Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return true;
    }

    private int getHeight(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        if (curr.left == null && curr.right == null) {
            return 1;
        }

        int left = 0;
        int right = 0;
        if (curr.left != null) {
            left = getHeight(curr.left);
        }
        if (curr.right != null) {
            right = getHeight(curr.right);
        }

        if (left == -1 || right == -1) {
            return -1;
        }
        int abs = (int) Math.abs(left - right);
        return abs > 1 ? -1 : Math.max(left, right) + 1;
    }
}
