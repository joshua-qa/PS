// 20ms. 정해랑 조금 다르지만 이 것도 O(N)이긴 함
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> depth;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parent = new HashMap<>();
        depth = new HashMap<>();
        dfs(root, root.val, 0);
        int pValue = p.val;
        int qValue = q.val;
        int pDepth = depth.get(p.val);
        int qDepth = depth.get(q.val);
        if (pDepth > qDepth) {
            while (pDepth != qDepth) {
                pValue = parent.get(pValue);
                pDepth = depth.get(pValue);
            }
        } else if (pDepth < qDepth) {
            while (qDepth != pDepth) {
                qValue = parent.get(qValue);
                qDepth = depth.get(qValue);
            }
        }

        while (pValue != qValue) {
            pValue = parent.get(pValue);
            qValue = parent.get(qValue);
        }
        return new TreeNode(pValue);
    }

    private void dfs(TreeNode curr, int prev, int level) {
        if (curr == null) {
            return;
        }
        parent.put(curr.val, prev);
        depth.put(curr.val, level);
        dfs(curr.left, curr.val, level+1);
        dfs(curr.right, curr.val, level+1);
    }
}
