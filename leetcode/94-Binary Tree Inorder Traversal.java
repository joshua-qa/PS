// 0ms. 까먹지 않게 복습하는 용도이기도 하고... Top 100 Liked Questions 에 있어서 풀어봄
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
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        dfs(root);
        return result;
    }
    private void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }

        dfs(curr.left);
        result.add(curr.val);
        dfs(curr.right);
    }
}
