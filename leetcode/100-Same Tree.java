// 0ms. 사실 리스트 없이도 풀 수 있더라.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        dfs(p, left);
        dfs(q, right);
        return left.equals(right);
    }

    private void dfs(TreeNode curr, List<Integer> paths) {
        if (curr == null) {
            paths.add(Integer.MIN_VALUE);
            return;
        }

        paths.add(curr.val);
        dfs(curr.left, paths);
        dfs(curr.right, paths);
    }
}
