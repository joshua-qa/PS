// 2ms. 짧고 간결하게 실수 없이 푸는 연습을 해야겠음.
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return dfs(root, root.val, targetSum);
    }

    private boolean dfs(TreeNode curr, int currSum, int targetSum) {
        if (curr.left == null && curr.right == null) {
            return currSum == targetSum;
        }

        boolean isEqualTargetSum = false;
        if (curr.left != null) {
            isEqualTargetSum = dfs(curr.left, currSum + curr.left.val, targetSum) | isEqualTargetSum;
        }
        if (curr.right != null) {
            isEqualTargetSum = dfs(curr.right, currSum + curr.right.val, targetSum) | isEqualTargetSum;
        }
        return isEqualTargetSum;
    }
}
