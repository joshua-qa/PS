// 1ms. 하드가 아니라는 의견도 있지만 엣지케이스를 고려하다보면 처음 푸는 사람한테는 어려운게 맞음.
// 문제 조건에 제시된 숫자들을 읽어보고 나올 수 있는 최대값 / 최소값을 미리 계산해서 초깃값을 설정하는게 좋다.
// 개인적으로 정말 좋은 트리 연습 문제라고 생각하며, 고민한 시간이 전혀 아깝지 않았다. 틀리지 않고 한번에 풀어서 만족!
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
    private int max;
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode curr) {
        max = Math.max(curr.val, max);
        if (curr.left == null && curr.right == null) {
            return curr.val;
        }

        if (curr.right == null) {
            int leftSum = dfs(curr.left) + curr.val;
            max = Math.max(max, leftSum);
            return Math.max(leftSum, curr.val);
        }

        if (curr.left == null) {
            int rightSum = dfs(curr.right) + curr.val;
            max = Math.max(max, rightSum);
            return Math.max(rightSum, curr.val);
        }

        // left != null, right != null
        int leftSum = dfs(curr.left) + curr.val;
        int rightSum = dfs(curr.right) + curr.val;
        int totalSum = leftSum + rightSum - curr.val;

        int compareResult = Math.max(leftSum, rightSum);
        max = Math.max(Math.max(compareResult, totalSum), max);
        return Math.max(compareResult, curr.val);
    }
}
