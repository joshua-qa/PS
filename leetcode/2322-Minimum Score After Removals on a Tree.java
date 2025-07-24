class Solution {
    private ArrayList<Integer>[] graph;
    private int n, fullXor, min;
    private int[] scores;

    public int minimumScore(int[] nums, int[][] edges) {
        n = nums.length;
        graph = new ArrayList[n + 1];
        scores = nums;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            fullXor ^= nums[i];
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }

        boolean[] visited = new boolean[n];
        // 잘라낼 edge 선정
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            // 서브 트리 xor 구하기
            visited[x] = true;
            int subXor = dfs1(y, visited);

            // 어떻게든 xor 점수 계산
            int rootXor = fullXor ^ subXor;
            visited[x] = false;
            dfs2(x, visited, rootXor, subXor);
            Arrays.fill(visited, false);
            visited[x] = true;
            dfs2(y, visited, subXor, rootXor);
            Arrays.fill(visited, false);
        }
        return min;
    }

    private int dfs1(int curr, boolean[] visited) {
        visited[curr] = true;
        int result = scores[curr];

        for (int next : graph[curr]) {
            if (visited[next]) {
                continue;
            }

            result ^= dfs1(next, visited);
        }
        return result;
    }

    private int dfs2(int curr, boolean[] visited, int rootXor, int anotherXor) {
        visited[curr] = true;

        int currScore = scores[curr];
        for (int next : graph[curr]) {
            if (visited[next]) {
                continue;
            }

            int subXor = dfs2(next, visited, rootXor, anotherXor);
            int excludeSubXor = rootXor ^ subXor;

            int currMax = Math.max(Math.max(excludeSubXor, subXor), anotherXor);
            int currMin = Math.min(Math.min(excludeSubXor, subXor), anotherXor);
            min = Math.min(min, currMax - currMin);

            currScore ^= subXor;
        }
        return currScore;
    }
}
