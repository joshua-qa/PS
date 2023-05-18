// 11ms. 릿코드 꽤 오랜만에 풀었는데 재밌게 풀었다.
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] targetingCount = new int[n];
        for (List<Integer> edge : edges) {
            targetingCount[edge.get(1)]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (targetingCount[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
