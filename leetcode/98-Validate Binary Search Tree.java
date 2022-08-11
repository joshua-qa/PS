// 0ms. 이런 문제 안 틀리고 한 번에 푸는 법좀 잘 익혀놔야겠다..
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValid(root.left, Integer.MIN_VALUE, (long) root.val-1) && isValid(root.right, (long) root.val+1, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }

        boolean isValidLeftNode = true;
        boolean isValidRightNode = true;
        if (root.left != null) {
            isValidLeftNode = isValid(root.left, min, (long) root.val-1);
        }
        if (root.right != null) {
            isValidRightNode = isValid(root.right, (long) root.val+1, max);
        }

        return isValidLeftNode && isValidRightNode;
    }
}
