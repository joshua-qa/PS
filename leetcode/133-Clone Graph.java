// 25ms. 좀 지저분하게 풀었는데 짧고 간결하게 푸는 방법 보니까 더 노력해야할듯.
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private List<List<Integer>> graph;
    private boolean[] visit;
    private int size;
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        visit = new boolean[101];
        visit[1] = true;
        dfs(node);
        size = graph.size();
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i < size; i++) {
            map.put(i, new Node(i, new ArrayList<>()));
        }

        for (int i = 1; i < size; i++) {
            List<Integer> curr = graph.get(i);
            for (int neighbor : curr) {
                map.get(i).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(1);
    }

    private void dfs(Node node) {
        int val = node.val;
        while (graph.size() <= val) {
            graph.add(new ArrayList<>());
        }
        for (Node next : node.neighbors) {
            graph.get(val).add(next.val);
            if (!visit[next.val]) {
                visit[next.val] = true;
                dfs(next);
            }
        }
    }
}
