// 1ms. 딱히 군더더기 없이 잘 풀었음
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
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return result;
    }
    private void dfs(TreeNode curr, int depth) {
        if (curr == null) {
            return;
        }
        if (depth > result.size()) {
            result.add(curr.val);
        }
        dfs(curr.right, depth+1);
        dfs(curr.left, depth+1);
    }
}
