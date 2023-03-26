// 128ms. 유니온 파인드는 필요 없었지만 처음 풀었던 코드가 1000ms를 넘겨서 해시맵으로 다시 풀음.
class Solution {
    private boolean[] visit;
    private int result, n;
    private int[] graph;
    public int longestCycle(int[] edges) {
        n = edges.length;
        graph = edges;
        visit = new boolean[n];
        result = -1;
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }
            Map<Integer, Integer> currVisit = new HashMap<>();
            dfs(i, currVisit, 1);
        }
        return result;
    }

    private void dfs(int curr, Map<Integer, Integer> currVisit, int count) {
        visit[curr] = true;
        currVisit.put(curr, count);

        int next = graph[curr];
        if (next == -1) {
            return;
        }

        if (!visit[next]) {
            dfs(next, currVisit, count+1);
        }

        int dist = currVisit.getOrDefault(next, 0);
        if (dist == 0) {
            return;
        }

        int cycleCount = currVisit.get(curr) - dist + 1;
        if (cycleCount > 1 && cycleCount > result) {
            result = cycleCount;
        }
    }
}
