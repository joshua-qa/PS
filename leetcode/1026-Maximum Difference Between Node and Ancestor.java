// 0ms. 전역변수 없이 풀어보려고 노력함.
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

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val, 0);
    }

    private int dfs(TreeNode curr, int currMin, int currMax, int currMaxAbs) {
        currMaxAbs = Math.max(Math.abs(currMax - currMin), currMaxAbs);
        if (curr.left == null && curr.right == null) {
            return currMaxAbs;
        }

        if (curr.left != null) {
            currMaxAbs = Math.max(currMaxAbs, dfs(curr.left, Math.min(currMin, curr.left.val), Math.max(currMax, curr.left.val), currMaxAbs));
        }
        if (curr.right != null) {
            currMaxAbs = Math.max(currMaxAbs, dfs(curr.right, Math.min(currMin, curr.right.val), Math.max(currMax, curr.right.val), currMaxAbs));
        }
        return currMaxAbs;
    }
}

