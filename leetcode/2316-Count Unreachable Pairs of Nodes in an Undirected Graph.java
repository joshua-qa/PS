// 28ms. 이래저래 사람 빡치게 하는 문제인 것만큼은 분명함.
class Solution {
    private int[] union;
    public long countPairs(int n, int[][] edges) {
        union = new int[n];
        for (int i = 1; i < n; i++) {
            union[i] = i;
        }

        for (int[] edge : edges) {
            connect(edge[0], edge[1]);
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int u : union) {
            int parent = find(u);
            int newValue = counts.getOrDefault(parent, 0) + 1;
            counts.put(parent, newValue);
        }

        long result = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            result += (long) entry.getValue() * (long) (n - entry.getValue());
        }
        return result / 2;
    }

    private void connect(int x, int y) {
        int xUnion = find(x);
        int yUnion = find(y);
        union[yUnion] = xUnion;
    }

    private int find(int x) {
        if (union[x] == x) {
            return x;
        }
        return union[x] = find(union[x]);
    }
}
