// 54ms. 메모리 얼마나 차지할지 고민도 해야하고, 이래저래 제법 생각을 해야하는 문제라 진짜 재밌었다.
// 제출할 때까지만 해도 조금 비효율적이라고 생각했는데.. 자바 제출자 중에서는 faster than 100% 나와서 뿌듯 (메모리도 less than 98.91%)
class Solution {
    private char[] labelChars;
    private boolean[] visit;
    private int[] result;
    private List<List<Integer>> tree;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        tree = new ArrayList<>();
        visit = new boolean[n];
        result = new int[n];
        labelChars = labels.toCharArray();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dfs(0);
        return result;
    }

    private int[] dfs(int curr) {
        visit[curr] = true;
        int[] count = new int[26];
        int ch = labelChars[curr] - 'a';
        count[ch]++;

        for (int next : tree.get(curr)) {
            if (visit[next]) {
                continue;
            }
            int[] nextResult = dfs(next);
            for (int i = 0; i < 26; i++) {
                count[i] += nextResult[i];
            }
        }
        result[curr] = count[ch];
        return count;
    }
}
