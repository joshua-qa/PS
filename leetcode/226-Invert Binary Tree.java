// 0ms. easy인데 꼭 풀어봐야하는 그런 유형
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        return makeNewTree(root, new TreeNode(root.val));
    }

    private TreeNode makeNewTree(TreeNode root, TreeNode newRoot) {
        if (root.left != null) {
            newRoot.right = makeNewTree(root.left, new TreeNode(root.left.val));
        }
        if (root.right != null) {
            newRoot.left = makeNewTree(root.right, new TreeNode(root.right.val));
        }
        return newRoot;
    }
}
