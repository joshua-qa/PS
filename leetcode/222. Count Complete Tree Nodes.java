// 0ms. 최적은 아니지만 나름 탐색수를 절반으로 줄여봄
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }
        if (root.right == null) {
            return 2;
        }

        TreeNode leftSubTree = root.left;
        TreeNode rightSubTree = root.right;
        TreeNode rightEnd = rightSubTree;
        TreeNode leftEnd = rightSubTree;
        int depth = 2;
        while (rightEnd.right != null) {
            leftEnd = leftEnd.left;
            rightEnd = rightEnd.right;
            depth++;
        }

        if (leftEnd.left != null) {
            return getMaxNode(rightSubTree, 3);
        } else {
            return Math.max(getMaxNode(leftSubTree, 2), (1 << depth) - 1);
        }
    }

    private int getMaxNode(TreeNode subTree, int currIndex) {
        int leftMaxNode = currIndex;
        int rightMaxNode = currIndex;
        if (subTree.left != null) {
            leftMaxNode = getMaxNode(subTree.left, currIndex * 2);
        }
        if (subTree.right != null) {
            rightMaxNode = getMaxNode(subTree.right, (currIndex * 2) + 1);
        }

        return Math.max(leftMaxNode, rightMaxNode);
    }
}
