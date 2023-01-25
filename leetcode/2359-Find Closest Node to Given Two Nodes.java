// 125ms. 설명을 주의깊게 읽지 않으면 100% 낚이는 문제다. 비추수가 많은건 다 이유가 있다.
class Solution {
    private int length;
    private static final int MAX = 987654321;
    private List<List<Integer>> graph;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        graph = new ArrayList<>();
        length = edges.length;
        for (int i = 0; i < length; i++) {
            List<Integer> edge = new ArrayList<>();
            edge.add(edges[i]);
            graph.add(edge);
        }
        int[] visit1 = bfs(node1);
        int[] visit2 = bfs(node2);
        int minIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (visit1[i] == MAX || visit2[i] == MAX) {
                continue;
            }

            int currMax = Math.max(visit1[i], visit2[i]);
            if (currMax < minDistance) {
                minIndex = i;
                minDistance = currMax;
            } else if (currMax == minDistance) {
                minIndex = Math.min(i, minIndex);
            }
        }
        return minIndex;
    }

    private int[] bfs(int start) {
        int[] visit = new int[length];
        Arrays.fill(visit, MAX);
        visit[start] = 0;
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        // key : index, value : visitCount
        queue.offer(new Pair<>(start, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            if (visit[curr.getKey()] < curr.getValue()) {
                continue;
            }

            for (int next : graph.get(curr.getKey())) {
                if (next == -1) {
                    continue;
                }
                if (visit[next] <= curr.getValue() + 1) {
                    continue;
                }
                visit[next] = curr.getValue() + 1;
                queue.offer(new Pair<>(next, curr.getValue() + 1));
            }
        }

        return visit;
    }
}
