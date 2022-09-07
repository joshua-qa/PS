// 2ms. 함정만 조심하면 쉬움
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
    private StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }

        sb.append(curr.val);

        if (curr.left != null) {
            sb.append("(");
            dfs(curr.left);
            sb.append(")");
        }

        if (curr.right != null) {
            if (curr.left == null) {
                sb.append("()");
            }
            sb.append("(");
            dfs(curr.right);
            sb.append(")");
        }
    }
}
