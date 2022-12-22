// 42ms. 가까스로 생각했던 풀이가 한발짝 부족했다. 하지만 의도자체는 맞았으니 다행...
// 이 문제는 나중에 다시 풀어볼 필요가 있다.
class Solution {
    private Queue<Pair<Integer, Integer>> queue;
    private List<Integer>[] graph;
    private boolean[] visited;
    private int[] counts, subNodeCounts, totalDist, parent;
    private int nodeCount;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new ArrayList[n];
        queue = new ArrayDeque<>();
        counts = new int[n];
        subNodeCounts = new int[n];
        totalDist = new int[n];
        parent = new int[n];
        visited = new boolean[n];
        nodeCount = n;
        Arrays.fill(subNodeCounts, 1);
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        visited[0] = true;
        dfs(0);
        counts[0] = totalDist[0];
        getSum(0, -1);
        return counts;
    }

    private Pair<Integer, Integer> dfs(int node) {
        for (int next : graph[node]) {
            if (visited[next]) {
                continue;
            }
            // <subNodeCount, totalDist>
            visited[next] = true;
            parent[next] = node;
            Pair<Integer, Integer> nextResult = dfs(next);
            subNodeCounts[node] += nextResult.getKey();
            totalDist[node] += nextResult.getValue() + (nextResult.getKey());
        }
        return new Pair<>(subNodeCounts[node], totalDist[node]);
    }

    private void getSum(int currNodeNumber, int prevNodeNumber) {
        for (int next : graph[currNodeNumber]) {
            if (next != prevNodeNumber) {
                int leftNodeCount = nodeCount - subNodeCounts[next];
                int leftSubTotalDist = counts[currNodeNumber] - totalDist[next] - subNodeCounts[next];
                counts[next] = leftNodeCount + leftSubTotalDist + totalDist[next];
                getSum(next, currNodeNumber);
            }
        }
    }
}
