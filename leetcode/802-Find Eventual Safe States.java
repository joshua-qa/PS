class Solution {
    private List<Integer> result = new ArrayList<>();
    private boolean[] visited;
    private int[] dp;
    private int n;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        n = graph.length;

        visited = new boolean[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }

        Collections.sort(result);
        return result;
    }

    private boolean dfs(int[][] graph, int curr) {
        if (visited[curr]) {
            return dp[curr] == 1;
        }

        visited[curr] = true;
        if (graph[curr].length == 0) {
            result.add(curr);
            dp[curr] = 1;
            return true;
        }

        boolean flag = true;
        for (int next : graph[curr]) {
            boolean nextResult = dfs(graph, next);
            if (!nextResult) {
                flag = false;
            }
        }

        if (flag) {
            result.add(curr);
            dp[curr] = 1;
        }
        return flag;
    }
}
