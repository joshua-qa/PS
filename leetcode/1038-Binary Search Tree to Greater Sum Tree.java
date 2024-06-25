// 0ms. 조금 헷갈렸지만 자력으로 풀어냈다. 상당히 재밌는 문제인데, 솔루션에 써있는 Morris Traversal은 처음 들어보는 기법이라 놀랬다.
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
    public TreeNode bstToGst(TreeNode root) {
        getResult(root, 0);
        return root;
    }

    private int getResult(TreeNode curr, int prevVal) {
        if (curr == null) {
            return prevVal;
        }

        curr.val += getResult(curr.right, prevVal);
        if (curr.left != null) {
            return getResult(curr.left, curr.val);
        }
        
        return curr.val;
    }
}
