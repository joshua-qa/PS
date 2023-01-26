// 34ms. 좀 당황스러울 수 있는데 다익스트라 쓰면 풀림.
class Solution {
    private static final int MAX = 987654321;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        int[][] min = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            if (i == src) {
                continue;
            }
            Arrays.fill(min[i], MAX);
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Pair<>(flight[1], flight[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.getCurrDist() == o2.getCurrDist()) {
                    return o1.getVisitCount() - o2.getVisitCount();
                }
                return o1.getCurrDist() - o2.getCurrDist();
            }
        });

        pq.offer(new Node(src, 0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.getNum() == dst) {
                min[dst][curr.getVisitCount()] = Math.min(curr.getCurrDist(), min[dst][curr.getVisitCount()]);
                continue;
            }

            int currVisit = curr.getVisitCount();
            for (Pair<Integer, Integer> next : graph.get(curr.getNum())) {
                int nextDist = curr.getCurrDist() + next.getValue();
                if (min[next.getKey()][currVisit+1] <= nextDist) {
                    continue;
                }
                if (currVisit == k && next.getKey() != dst) {
                    continue;
                }

                min[next.getKey()][currVisit+1] = nextDist;
                pq.offer(new Node(next.getKey(), nextDist, next.getKey() == dst ? currVisit : currVisit+1));
            }
        }

        int result = MAX;
        for (int totalDist : min[dst]) {
            if (result > totalDist) {
                result = totalDist;
            }
        }
        return result == MAX ? -1 : result;
    }
}

class Node {
    private int num;
    private int currDist;
    private int visitCount;

    public Node(int num, int currDist, int visitCount) {
        this.num = num;
        this.currDist = currDist;
        this.visitCount = visitCount;
    }

    public int getNum() {
        return num;
    }

    public int getCurrDist() {
        return currDist;
    }

    public int getVisitCount() {
        return visitCount;
    }
}
