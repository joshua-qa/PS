// 16ms. 나름 재밌는 문제였음. 제출할 때마다 메모리 사용량이 40mb씩 왔다갔다하는게 좀 이상했지만
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
    private int[] count;
    private int result;
    public int pseudoPalindromicPaths (TreeNode root) {
        count = new int[10];
        result = 0;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }
        count[curr.val]++;
        if (curr.left == null && curr.right == null) {
            int oddCount = 0;
            for (int num : count) {
                if ((num & 1) == 1) {
                    oddCount++;
                }
            }
            if (oddCount < 2) {
                result++;
            }
            count[curr.val]--;
            return;
        }

        if (curr.left != null) {
            dfs(curr.left);
        }
        if (curr.right != null) {
            dfs(curr.right);
        }
        count[curr.val]--;
    }
}