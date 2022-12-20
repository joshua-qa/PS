// 49ms. 어제 하루종일 밖에 있어서 아이패드로 풀었는데 DFS로 풀었더니 189ms가 나왔었다.
// 생각해보니 소요시간 줄일 수 있을 것 같아서 이중 List 대신 List 배열로 처리하고 BFS로 바꿈
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        visited[source] = true;
        queue.offer(source);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == destination) {
                return true;
            }

            for (int next : graph[curr]) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.offer(next);
            }
        }

        return visited[destination];
    }
}
