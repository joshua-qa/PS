// 1ms. 트리가 어떤 식으로 바뀔지 잘 상상하면서 풀어야된다.
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        findAndAdd(root, val, depth, 1);
        return root;
    }

    private void findAndAdd(TreeNode curr, int val, int depth, int currDepth) {
        if (curr == null) {
            return;
        }
        if (depth-1 == currDepth) {
            TreeNode newNode = new TreeNode(val);
            if (curr.left != null) {
                newNode.left = curr.left;
            }
            curr.left = newNode;

            TreeNode newNode2 = new TreeNode(val);
            if (curr.right != null) {
                newNode2.right = curr.right;
            }
            curr.right = newNode2;

            return;
        }

        findAndAdd(curr.left, val, depth, currDepth+1);
        findAndAdd(curr.right, val, depth, currDepth+1);
    }
}
