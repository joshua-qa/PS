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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkChildNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean checkChildNode(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        if (root.left != null && root.left.val == root.val) {
            return false;
        }
        if (root.right != null && root.right.val == root.val) {
            return false;
        }
        return checkChildNode(root.left, min, (long)root.val - 1) && checkChildNode(root.right, (long)root.val + 1, max);
    }
}