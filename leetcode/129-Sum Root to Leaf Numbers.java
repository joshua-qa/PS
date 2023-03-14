// 0ms. 생각보다 어렵지 않음.
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
    public int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = (root.left != null) ? sum(root.left, root.val) : 0;
        int right = (root.right != null) ? sum(root.right, root.val) : 0;
        return left + right;
    }

    private int sum(TreeNode curr, int currNum) {
        currNum = (currNum * 10) + curr.val;

        if (curr.left == null && curr.right == null) {
            return currNum;
        }

        int left = (curr.left != null) ? sum(curr.left, currNum) : 0;
        int right = (curr.right != null) ? sum(curr.right, currNum) : 0;
        return left + right;
    }
}
