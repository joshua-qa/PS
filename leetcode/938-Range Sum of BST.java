// 1ms. 이지 난이도지만 꼭 풀어봐야 하는 종류의 문제
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int rootVal = root.val;
        if (root.val < low || root.val > high) {
            rootVal = 0;
        }

        return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + rootVal;
    }
}
