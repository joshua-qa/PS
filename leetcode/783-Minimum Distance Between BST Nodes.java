// 1ms. 리스트를 사용하지 않고 푸는 솔루션은 참고해둘법 하다.
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
    TreeSet<Integer> tree;
    public int minDiffInBST(TreeNode root) {
        tree = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        int prev = -1;
        dfs(root);
        for (int key : tree) {
            if (prev == -1) {
                prev = key;
                continue;
            }
            if (key - prev < min) {
                min = key - prev;
            }
            prev = key;
        }
        return min;
    }

    private void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }
        tree.add(curr.val);

        if (curr.left != null) {
            dfs(curr.left);
        }
        
        if (curr.right != null) {
            dfs(curr.right);
        }
    }
}
