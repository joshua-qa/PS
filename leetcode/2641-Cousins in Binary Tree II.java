
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private Map<Integer, Integer> sumOfCousins;
    public TreeNode replaceValueInTree(TreeNode root) {
        sumOfCousins = new HashMap<>();
        getSum(root, 0);
        fill(root, 0, root.val);
        return root;
    }

    private void getSum(TreeNode curr, int currDepth) {
        if (curr == null) {
            return;
        }

        int currSum = sumOfCousins.getOrDefault(currDepth, 0);
        currSum += curr.val;

        sumOfCousins.put(currDepth, currSum);

        getSum(curr.left, currDepth + 1);
        getSum(curr.right, currDepth + 1);
    }

    private void fill(TreeNode curr, int currDepth, int sumCousinExcludeSameParent) {
        if (curr == null) {
            return;
        }

        curr.val = sumCousinExcludeSameParent - curr.val;

        if (curr.left == null && curr.right == null) {
            return;
        }

        int sumOfNextDepth = sumOfCousins.get(currDepth + 1);
        int excludeLeft = (curr.left != null) ? sumOfNextDepth - curr.left.val : sumOfNextDepth;
        int excludeRight = (curr.right != null) ? sumOfNextDepth - curr.right.val : sumOfNextDepth;

        fill(curr.left, currDepth + 1, excludeRight);
        fill(curr.right, currDepth + 1, excludeLeft);
    }
}
