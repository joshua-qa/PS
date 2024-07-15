import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> childNodes = new HashSet<>();
        for (int[] description : descriptions) {
            childNodes.add(description[1]);
            if (!nodes.containsKey(description[0])) {
                nodes.put(description[0], new TreeNode(description[0]));
            }
            if (!nodes.containsKey(description[1])) {
                nodes.put(description[1], new TreeNode(description[1]));
            }

            if (description[2] == 1) {
                nodes.get(description[0]).left = nodes.get(description[1]);
            } else {
                nodes.get(description[0]).right = nodes.get(description[1]);
            }
        }

        TreeNode root = null;
        for (int key : nodes.keySet()) {
            if (!childNodes.contains(key)) {
                root = nodes.get(key);
                break;
            }
        }

        return root;
    }
}
