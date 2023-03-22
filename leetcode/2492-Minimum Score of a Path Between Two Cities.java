// 47ms. 유니온 파인드를 썼으면 더 빨랐을듯
class Solution {
    public int minScore(int n, int[][] roads) {
        int[] visitDistance = new int[n+1];
        Arrays.fill(visitDistance, Integer.MAX_VALUE);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
            if (visitDistance[road[0]] > road[2]) {
                visitDistance[road[0]] = road[2];
            }
            if (visitDistance[road[1]] > road[2]) {
                visitDistance[road[1]] = road[2];
            }
        }
        boolean[] visit = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visit[1] = true;
        Set<Integer> paths = new HashSet<>();
        paths.add(1);
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int nextNode : graph.get(curr)) {
                if (visit[nextNode]) {
                    continue;
                }
                visit[nextNode] = true;
                paths.add(nextNode);
                queue.offer(nextNode);
            }
        }

        for (int path : paths) {
            if (result > visitDistance[path]) {
                result = visitDistance[path];
            }
        }
        return result;
    }
}
