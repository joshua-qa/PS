// 25ms. 이분 그래프 하도 오랜만에 풀어서 헷갈렸다... 그래도 이 문제는 관련 문제중에 제일 기본형이라 쉬웠음
// 현재 노드와 간선으로 이어지는 노드를 다른 색으로 색칠하면서 DFS를 돌려주고, 이미 방문한 노드가 같은 색으로 색칠되어 있으면 false
class Solution {
    private boolean[] visited;
    private int[] color;
    private List<Integer>[] graph;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        visited = new boolean[n+1];
        color = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int curr) {
        for (int next : graph[curr]) {
            if (visited[next]) {
                if (color[next] == color[curr]) {
                    return false;
                }
                continue;
            }

            color[next] = (color[curr] == 0) ? 1 : 0;
            visited[next] = true;
            dfs(next);
        }
        return true;
    }
}
