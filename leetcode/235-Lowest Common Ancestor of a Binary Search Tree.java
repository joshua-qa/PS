// 5ms.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = (p.val > q.val) ? q.val : p.val;
        int max = (p.val > q.val) ? p.val : q.val;
        return dfs(root, min, max);
    }

    private TreeNode dfs(TreeNode root, int low, int high) {
        if (low == root.val || high == root.val || low < root.val && high > root.val) {
            return root;
        }

        if (high < root.val) {
            return dfs(root.left, low, high);
        }
        return dfs(root.right, low, high);
    }
}

