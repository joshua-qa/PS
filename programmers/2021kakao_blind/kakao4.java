import java.util.*;
class Solution {
    List<List<Node>> graph;
    int result;
    final int MAX = 100000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        result = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Node(fare[0], fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[1], fare[0], fare[2]));
        }

        int[] sDist = bfs(n, s);
        int[] aDist = bfs(n, a);
        int[] bDist = bfs(n, b);
        for (int i = 1; i <= n; i++) {
            int currentDist = sDist[i] + aDist[i] + bDist[i];
            result = Math.min(result, currentDist);
        }

        return result;
    }

    private int[] bfs(int n, int start) {
        int[] dists = new int[n+1];
        Queue<Dist> queue = new PriorityQueue<>();

        Arrays.fill(dists, MAX);
        dists[start] = 0;
        queue.offer(new Dist(start, 0));
        while (!queue.isEmpty()) {
            Dist dist = queue.poll();

            if (dist.dist > dists[dist.point]) {
                continue;
            }

            for (Node node : graph.get(dist.point)) {
                if (dists[node.getY()] > dist.dist + node.getFare()) {
                    dists[node.getY()] = dist.dist + node.getFare();
                    queue.offer(new Dist(node.getY(), dists[node.getY()]));
                }
            }
        }
        return dists;
    }
}

class Dist implements Comparable<Dist> {
    int point;
    int dist;

    public Dist(int point, int dist) {
        this.point = point;
        this.dist = dist;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    @Override
    public int compareTo(Dist o) {
        return this.dist - o.dist;
    }
}

class Node {
    int x;
    int y;
    int fare;

    public Node(int x, int y, int fare) {
        this.x = x;
        this.y = y;
        this.fare = fare;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}