// 16ms. N제한이 워낙 작아서 이정도만 해줘도 충분하다.
class Solution {
    private HashSet<List<Integer>> resultSet;
    private int length;
    private int[] values;
    public List<List<Integer>> findSubsequences(int[] nums) {
        length = nums.length;
        values = nums;
        List<List<Integer>> result = new ArrayList<>();
        if (length == 1) {
            return Collections.emptyList();
        }
        resultSet = new HashSet<>();
        for (int i = 0; i < length-1; i++) {
            dfs(i, new ArrayList<>());
        }

        for (List<Integer> subSequence : resultSet) {
            result.add(subSequence);
        }
        return result;
    }

    private void dfs(int currIndex, List<Integer> currSequence) {
        if (currIndex == length) {
            if (currSequence.size() > 1) {
                resultSet.add(currSequence);
            }
            return;
        }

        currSequence.add(values[currIndex]);
        for (int i = currIndex+1; i <= length; i++) {
            if (i == length || values[i] >= values[currIndex]) {
                dfs(i, new ArrayList<>(currSequence));
            }
        }
    }
}

