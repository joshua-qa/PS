// 82ms. 진짜 도전적인 문제였다. 거의 두시간 이상 고민해서 자력으로 풀긴 풀었다.
class Solution {
    private List<List<Integer>> tree;
    private int[] subtree;
    private boolean[] visit;
    public long minimumFuelCost(int[][] roads, int seats) {
        int roadSize = roads.length;
        if (roadSize == 0) {
            return 0;
        }

        subtree = new int[roadSize+1];
        visit = new boolean[roadSize+1];
        long result = 0;
        tree = new ArrayList<>();
        for (int i = 0; i <= roadSize; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        dfs(0, 0);

        Arrays.fill(visit, false);
        visit[0] = true;
        for (int start : tree.get(0)) {
            result += getSize(start, seats);
        }
        return result;
    }

    private long getCarSize(int seats, int subTreeSize) {
        return subTreeSize % seats == 0 ? subTreeSize / seats : ((subTreeSize / seats) + 1);
    }

    private long getSize(int curr, int seats) {
        visit[curr] = true;
        if (subtree[curr] == 1) {
            return 1;
        }

        long dist = 0;
        for (int next : tree.get(curr)) {
            if (visit[next]) {
                continue;
            }
            long nextResult = getSize(next, seats);
            dist += nextResult;
        }

        long carSize = getCarSize(seats, subtree[curr]);
        return dist + carSize;
    }

    private int dfs(int curr, int currDepth) {
        visit[curr] = true;
        subtree[curr] = 1;
        if (tree.get(curr).isEmpty()) {
            return 1;
        }

        for (int next : tree.get(curr)) {
            if (visit[next]) {
                continue;
            }
            subtree[curr] += dfs(next, currDepth+1);
        }
        return subtree[curr];
    }
}
