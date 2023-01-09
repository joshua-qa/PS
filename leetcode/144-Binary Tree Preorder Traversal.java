// 0ms. 가볍게 2분컷했다.
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
    private List<Integer> nodes;
    public List<Integer> preorderTraversal(TreeNode root) {
        nodes = new ArrayList<>();
        dfs(root);
        return nodes;
    }

    private void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }

        nodes.add(curr.val);
        dfs(curr.left);
        dfs(curr.right);
    }
}
