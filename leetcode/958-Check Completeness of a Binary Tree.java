// 2ms. 너무 생각이 안나서 일단 답만 나오게 풀었음. 다음에 다시 풀어야함.
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    private boolean[] exist;
    private Queue<Pair<TreeNode, Integer>> queue;
    public boolean isCompleteTree(TreeNode root) {
        exist = new boolean[101];
        queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            int value = curr.getValue();
            TreeNode key = curr.getKey();
            if (value > 100) {
                return false;
            }

            exist[value] = true;
            if (key.left == null) {
                if (key.right != null) {
                    return false;
                }
                continue;
            }

            queue.offer(new Pair<>(key.left, value*2));
            if (key.right != null) {
                queue.offer(new Pair<>(key.right, (value*2) + 1));
            }
        }

        for (int i = 1; i < 100; i++) {
            if (!exist[i] && exist[i+1]) {
                return false;
            }
        }
        return true;
    }
}
