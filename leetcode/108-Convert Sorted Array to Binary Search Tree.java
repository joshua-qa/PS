// 0ms. 1ms 나와서 제출 한번 더 눌렀더니 0ms 나옴..
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (start != mid) {
            node.left = buildTree(nums, start, mid-1);
        }
        if (end != mid) {
            node.right = buildTree(nums, mid+1, end);
        }

        return node;
    }
}
