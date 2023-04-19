// 6ms. 최근에 푼 문제 중에서 가장 재밌었다.
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
    private int max;
    public int longestZigZag(TreeNode root) {
        if (root.left != null) {
            dfs(root.left, 1, true);
        }
        if (root.right != null) {
            dfs(root.right, 1, false);
        }
        return max;
    }

    private void dfs(TreeNode curr, int level, boolean isPrevLeft) {
        if (curr == null) {
            return;
        }

        max = Math.max(max, level);

        if (curr.left != null) {
            dfs(curr.left, (isPrevLeft ? 1 : level+1), true);
        }

        if (curr.right != null) {
            dfs(curr.right, (isPrevLeft ? level+1 : 1), false);
        }
    }
}
