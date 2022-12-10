// 13ms. 상당히 재밌는 문제임. 리스트를 만들지 않고도 풀 수 있겠지만... 그건 다음 기회에
// 그리고 이걸로 leetcode 200문제 달성!
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
    private long sum;
    private List<Long> prefixSum;
    public int maxProduct(TreeNode root) {
        prefixSum = new ArrayList<>();
        sum = dfs(root);
        long abs = Integer.MAX_VALUE;
        long result = 0;
        for (long currSum : prefixSum) {
            long currAbs = Math.abs((sum - currSum) - currSum);
            if (currAbs < abs) {
                abs = currAbs;
                result = currSum;
            }
        }

        long product = (sum - result) * result;

        return (int)(product % 1000000007);
    }

    private long dfs(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        long currSum = dfs(curr.left) + dfs(curr.right) + curr.val;
        prefixSum.add(currSum);
        return currSum;
    }
}
