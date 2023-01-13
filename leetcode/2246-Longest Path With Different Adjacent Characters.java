// 101ms. 하드라서 놀랬는데 한번에 맞았다. 이런류의 문제들은 접근법이 이제 어느정도 눈에 들어오는듯.
class Solution {
    private List<List<Integer>> tree;
    private boolean[] visit;
    private char[] chars;
    private int max, n;
    public int longestPath(int[] parent, String s) {
        n = parent.length;
        tree = new ArrayList<>();
        chars = s.toCharArray();
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }

        int result = dfs(0);
        return max > result ? max : result;
    }

    private int dfs(int curr) {
        visit[curr] = true;

        int first = 0, second = 0;
        for (int next : tree.get(curr)) {
            if (visit[next]) {
                continue;
            }

            if (chars[next] == chars[curr]) {
                dfs(next);
                continue;
            }

            int count = dfs(next);
            if (count > first) {
                second = first;
                first = count;
            } else if (count <= first && count > second) {
                second = count;
            }
        }
        int currMax = 1 + first + second;
        if (max < currMax) {
            max = currMax;
        }
        return 1 + first;
    }
}
