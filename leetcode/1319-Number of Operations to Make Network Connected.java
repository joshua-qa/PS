// 7ms. 유니온 파인드를 진짜 한 100번 써보고 외워야 하나...? 껍데기는 기억하는데 디테일한 코드를 살짝 헷갈린다.
class Solution {
    private int[] union;
    public int makeConnected(int n, int[][] connections) {
        if (n > connections.length + 1) {
            return -1;
        }

        union = new int[n];
        for (int i = 1; i < n; i++) {
            union[i] = i;
        }

        for (int[] connection : connections) {
            connect(connection[0], connection[1]);
        }

        Set<Integer> unionCount = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unionCount.add(find(i));
        }
        return unionCount.size()-1;
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
