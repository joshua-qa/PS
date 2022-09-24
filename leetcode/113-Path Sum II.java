// 2ms. 순서 저장 방법이 관건임
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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Deque<Integer> stack = new ArrayDeque<>();
        result = new ArrayList<>();
        dfs(root, 0, targetSum, stack);
        return result;
    }

    private void dfs(TreeNode curr, int currSum, int targetSum, Deque<Integer> stack) {
        if (curr == null) {
            return;
        }

        stack.addLast(curr.val);
        if (curr.left == null && curr.right == null) {
            if (currSum + curr.val == targetSum) {
                result.add(new ArrayList<>(stack));
            }
            stack.pollLast();
            return;
        }

        dfs(curr.left, currSum + curr.val, targetSum, stack);
        dfs(curr.right, currSum + curr.val, targetSum, stack);
        stack.pollLast();
    }
}
