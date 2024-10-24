/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Map<Integer, Integer> root1Nodes = new HashMap<>();
        Map<Integer, Integer> root2Nodes = new HashMap<>();
        if (root1 == null && root2 == null) {
            return true;
        }

        dfs(root1, root1Nodes, -1);
        dfs(root2, root2Nodes, -1);

        if (root1Nodes.size() != root2Nodes.size()) {
            return false;
        }

        for (Map.Entry<Integer, Integer> node : root1Nodes.entrySet()) {
            if (!root2Nodes.containsKey(node.getKey())) {
                return false;
            }
            if (!root2Nodes.get(node.getKey()).equals(node.getValue())) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode curr, Map<Integer, Integer> nodes, int parent) {
        if (curr == null) {
            return;
        }

        nodes.put(curr.val, parent);

        dfs(curr.left, nodes, curr.val);
        dfs(curr.right, nodes, curr.val);
    }
}
