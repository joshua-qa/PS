// 2ms. 재밌는 문제였다
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
    List<Integer> left, right;
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        left = new ArrayList<>();
        right = new ArrayList<>();
        dfs(root.left, true);
        dfs(root.right, false);
        if (left.size() != right.size()) {
            return false;
        }
        return left.equals(right);
    }

    private void dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            if (isLeft) {
                left.add(null);
            } else {
                right.add(null);
            }
            return;
        }

        if (isLeft) {
            left.add(root.val);
            dfs(root.left, true);
            dfs(root.right, true);
        } else {
            right.add(root.val);
            dfs(root.right, false);
            dfs(root.left, false);
        }
    }
}
