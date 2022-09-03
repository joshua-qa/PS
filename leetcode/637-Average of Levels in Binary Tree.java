// 3ms. 요령만 알면 쉬움
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
    List<List<Integer>> depthNumList;
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        depthNumList = new ArrayList<>();
        dfs(1, root);
        for (List<Integer> nums : depthNumList) {
            long total = 0;
            for (int num : nums) {
                total += (long) num;
            }
            double average = (double) total / (double) nums.size();
            result.add(average);
        }
        return result;
    }

    private void dfs(int depth, TreeNode root) {
        if (depthNumList.size() < depth) {
            depthNumList.add(new ArrayList<>());
        }

        depthNumList.get(depth-1).add(root.val);
        if (root.left != null) {
            dfs(depth+1, root.left);
        }
        if (root.right != null) {
            dfs(depth+1, root.right);
        }
    }
}
