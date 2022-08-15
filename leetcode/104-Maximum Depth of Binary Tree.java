// 0ms. Top 100 Liked Questions에 있어서 풀어봄
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
    int result;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth(root, 1);
        return result;
    }

    private void getDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth > result) {
            result = depth;
        }

        if (root.left != null) {
            getDepth(root.left, depth+1);
        }

        if (root.right != null) {
            getDepth(root.right, depth+1);
        }
    }
}
