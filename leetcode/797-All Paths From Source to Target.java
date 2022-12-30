// 3ms. n이 작아서 그냥 visit를 배열로 쓰고 binarySearch를 활용했는데 deque를 쓰는게 더 자연스러웠을듯
class Solution {
    private List<Set<Integer>> dag;
    private List<List<Integer>> result;
    private int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dag = new ArrayList<>();
        result = new ArrayList<>();
        n = graph.length - 1;
        for (int[] path : graph) {
            Set<Integer> nodes = new HashSet<>();
            for (int node : path) {
                nodes.add(node);
            }
            dag.add(nodes);
        }

        int[] visit = new int[n+1];
        dfs(0, 1, visit);
        return result;
    }

    private void dfs(int currNode, int visitCount, int[] visit) {
        if (currNode == n) {
            List<Integer> paths = new ArrayList<>();
            for (int i = 0; i < visitCount; i++) {
                paths.add(visit[i]);
            }
            result.add(paths);
            return;
        }

        for (int next : dag.get(currNode)) {
            if (Arrays.binarySearch(visit, next) > -1) {
                continue;
            }

            visit[visitCount] = next;
            dfs(next, visitCount+1, visit);
            visit[visitCount] = 0;
        }
    }
}
