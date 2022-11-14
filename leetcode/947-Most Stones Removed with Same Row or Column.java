// 71ms. 너무 어렵게 생각했는데 결국 토픽이 뭔지 보고 풀었다.. 이런 패턴 더 연습해야함
class Solution {
    private boolean[] visit;
    private int[] union;
    private int length;
    public int removeStones(int[][] stones) {
        length = stones.length;
        int count = 0;
        union = new int[length];
        visit = new boolean[length];
        for (int i = 0; i < length; i++) {
            union[i] = i;
        }

        for (int i = 0; i < length; i++) {
            if (visit[i]) {
                continue;
            }
            dfs(stones, i);
        }

        for (int i = 0; i < length; i++) {
            if (union[i] == i) {
                count++;
            }
        }

        return length - count;
    }

    private void dfs(int[][] stones, int currIndex) {
        visit[currIndex] = true;

        int x = stones[currIndex][0];
        int y = stones[currIndex][1];

        for (int i = 0; i < length; i++) {
            if (visit[i]) {
                continue;
            }
            int[] stone = stones[i];
            if (stone[0] != x && stone[1] != y) {
                continue;
            }

            union(currIndex, i);
            dfs(stones, i);
        }
    }

    private void union(int a, int b) {
        int parent = find(a);
        union[b] = parent;
    }

    private int find(int a) {
        if (union[a] == a) {
            return a;
        }
        return union[a] = find(union[a]);
    }
}
