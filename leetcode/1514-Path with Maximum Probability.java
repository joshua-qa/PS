class Solution {
    private List<List<Edge>> graph;
    private double[] dist;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // dijkstra
        graph = new ArrayList<List<Edge>>();
        dist = new double[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Double.NEGATIVE_INFINITY;
        }

        int i = 0;
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Edge(edge[1], succProb[i]));
            graph.get(edge[1]).add(new Edge(edge[0], succProb[i++]));
        }

        dijkstra(n, start_node, end_node);
        return dist[end_node] == Double.NEGATIVE_INFINITY ? 0.0 : dist[end_node];
    }

    private void dijkstra(int n, int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue(new Comparator<Edge>() {
            @Override
            public int compare(Edge edge, Edge t1) {
                return Double.compare(t1.probability, edge.probability);
            }
        });
        pq.offer(new Edge(start, 1.0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (dist[edge.target] > edge.probability) {
                continue;
            }

            for (Edge next : graph.get(edge.target)) {
                double currDist = edge.probability * next.probability;
                if (dist[next.target] < currDist) {
                    dist[next.target] = currDist;
                    pq.offer(new Edge(next.target, currDist));
                }
            }
        }
    }

    static class Edge {
        private int target;
        private double probability;

        public Edge(int target, double probability) {
            this.target = target;
            this.probability = probability;
        }

        public int getTarget() {
            return target;
        }

        public double getProbability() {
            return probability;
        }
    }
}
