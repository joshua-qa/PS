// 1ms. 이진트리 쪽에서 비슷한 문제들 풀어봤으면 전혀 차이 없음
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> levelOrder(Node root) {
        result = new ArrayList<>();
        dfs(1, root);
        return result;
    }

    private void dfs(int depth, Node curr) {
        if (curr == null) {
            return;
        }

        if (result.size() < depth) {
            List<Integer> vals = new ArrayList<>();
            vals.add(curr.val);
            result.add(vals);
        } else {
            result.get(depth-1).add(curr.val);
        }

        if (curr.children != null) {
            for (Node child : curr.children) {
                dfs(depth + 1, child);
            }
        }
    }
}
