// 2ms. 한번에 맞아서 기분 좋았다. 트리는 역시 많이 연습해둬야..
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
    int result;
    public int goodNodes(TreeNode root) {
        dfs(Integer.MIN_VALUE, root);
        return result;
    }

    private void dfs(int maxVal, TreeNode curr) {
        if (curr == null) {
            return;
        }

        int currMaxVal = maxVal;
        if (currMaxVal <= curr.val) {
            currMaxVal = curr.val;
            result++;
        }
        if (curr.left != null) {
            dfs(currMaxVal, curr.left);
        }
        if (curr.right != null) {
            dfs(currMaxVal, curr.right);
        }
    }
}
