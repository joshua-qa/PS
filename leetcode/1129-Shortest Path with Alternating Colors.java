// 5ms. 두가지 케이스를 다 고려해서 bfs를 돌려주어야 한다. 한번에 맞아서 기분 좋은 문제였다.
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] visitCount = new int[n][2];
        List<Pair<Integer, Boolean>>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            if (i == 0) {
                continue;
            }
            visitCount[i][0] = Integer.MAX_VALUE;
            visitCount[i][1] = Integer.MAX_VALUE;
        }
        // true : isRed
        for (int[] redEdge : redEdges) {
            graph[redEdge[0]].add(new Pair<>(redEdge[1], true));
        }
        for (int[] blueEdge : blueEdges) {
            graph[blueEdge[0]].add(new Pair<>(blueEdge[1], false));
        }

        Queue<Edge> queue = new ArrayDeque<>();
        queue.offer(new Edge(0, 0, true));
        queue.offer(new Edge(0, 0, false));
        while (!queue.isEmpty()) {
            Edge curr = queue.poll();

            for (Pair<Integer, Boolean> next : graph[curr.getTarget()]) {
                if (!isAvailableEdge(curr, next)) {
                    continue;
                }
                int colorIndex = next.getValue() ? 0 : 1;
                if (curr.getCurrCount() + 1 >= visitCount[next.getKey()][colorIndex]) {
                    continue;
                }

                visitCount[next.getKey()][colorIndex] = curr.getCurrCount() + 1;
                queue.offer(new Edge(next.getKey(), curr.getCurrCount() + 1, next.getValue()));
            }
        }

        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            if (visitCount[i][0] == Integer.MAX_VALUE && visitCount[i][1] == Integer.MAX_VALUE) {
                result[i] = -1;
                continue;
            }
            result[i] = visitCount[i][0] > visitCount[i][1] ? visitCount[i][1] : visitCount[i][0];
        }
        return result;
    }

    private boolean isAvailableEdge(Edge curr, Pair<Integer, Boolean> target) {
        return curr.isRed() != target.getValue();
    }
}

class Edge {
    private int target;
    private int currCount;
    private boolean isRed;

    public Edge(int target, int currCount, boolean isRed) {
        this.target = target;
        this.currCount = currCount;
        this.isRed = isRed;
    }

    public int getTarget() {
        return target;
    }

    public int getCurrCount() {
        return currCount;
    }

    public boolean isRed() {
        return isRed;
    }
}
