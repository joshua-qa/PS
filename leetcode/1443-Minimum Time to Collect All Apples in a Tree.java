// 65ms. 방향성이 없다는걸 고려하지 못하고 엣지케이스 처리를 안해서 한번 틀림;
class Solution {
    private List<HashSet<Integer>> tree;
    private boolean[] visit;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        tree = new ArrayList<>();
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        visit[0] = true;
        return dfs(0, hasApple);
    }

    private int dfs(int curr, List<Boolean> hasApple) {
        if (tree.get(curr).isEmpty()) {
            return hasApple.get(curr) ? 2 : 0;
        }

        int result = 0;
        int appendValue = curr == 0 ? 0 : 2;
        for (int next : tree.get(curr)) {
            if (visit[next]) {
                continue;
            }
            visit[next] = true;
            result += dfs(next, hasApple);
        }
        if (hasApple.get(curr)) {
            return result + appendValue;
        }
        return result == 0 ? 0 : result + appendValue;
    }
}
