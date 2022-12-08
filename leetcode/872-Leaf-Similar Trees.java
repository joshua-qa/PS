// 1ms. 트리 순회법을 알고 있으면 5분 컷
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();

        dfs(root1, leaf1);
        dfs(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    private void dfs(TreeNode curr, List<Integer> leafs) {
        if (curr == null) {
            return;
        }

        if (curr.left == null && curr.right == null) {
            leafs.add(curr.val);
            return;
        }

        if (curr.left != null) {
            dfs(curr.left, leafs);
        }
        if (curr.right != null) {
            dfs(curr.right, leafs);
        }
    }
}
