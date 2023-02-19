// 0ms. 일단 다 넣어놓고 나중에 뒤집는게 편하다.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private List<List<Integer>> result;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 1);
        int maxLevel = result.size();
        for (int i = 0; i < maxLevel; i++) {
            if ((i & 1) == 1) {
                Collections.reverse(result.get(i));
            }
        }

        return result;
    }

    private void dfs(TreeNode curr, int level) {
        if (result.size() < level) {
            result.add(new ArrayList<>());
        }

        result.get(level-1).add(curr.val);
        if (curr.left != null) {
            dfs(curr.left, level+1);
        }
        if (curr.right != null) {
            dfs(curr.right, level+1);
        }
    }
}
