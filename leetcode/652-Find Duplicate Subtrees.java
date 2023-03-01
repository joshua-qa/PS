// 30ms. 솔루션이 놀랍다. 문자열로 접근할 생각을 못했기 때문... 다음에 다시 풀어봐야겠다.
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

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
    private Map<List<Integer>, Integer> subTrees;
    private Set<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root.left == null && root.right == null) {
            return Collections.emptyList();
        }
        subTrees = new HashMap<>();
        result = new HashSet<>();
        dfs(root);
        return new ArrayList<>(result);
    }

    private List<Integer> dfs(TreeNode curr) {
        List<Integer> currSubTree = new ArrayList<>();
        currSubTree.add(curr.val);

        if (curr.left == null && curr.right == null) {
            int count = subTrees.getOrDefault(currSubTree, 0);
            if (count == 1) {
                result.add(curr);
                subTrees.put(currSubTree, 2);
            } else if (count == 0) {
                subTrees.put(currSubTree, 1);
            }
            return currSubTree;
        }

        if (curr.left != null) {
            currSubTree.addAll(dfs(curr.left));
        } else {
            currSubTree.add(null);
        }

        if (curr.right != null) {
            currSubTree.addAll(dfs(curr.right));
        } else {
            currSubTree.add(null);
        }

        int count = subTrees.getOrDefault(currSubTree, 0);
        if (count == 1) {
            result.add(curr);
            subTrees.put(currSubTree, 2);
        } else if (count == 0) {
            subTrees.put(currSubTree, 1);
        }

        return currSubTree;
    }
}
