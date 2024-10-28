class Solution {
    private int[] sortedNums;
    private boolean[] visited;
    private int max;
    public int longestSquareStreak(int[] nums) {
        max = 1;
        int size = nums.length;
        Arrays.sort(nums);
        sortedNums = nums;
        visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                dfs(i, 1);
            }
        }

        return max > 1 ? max : -1;
    }

    private void dfs(int currIndex, int currCount) {
        visited[currIndex] = true;

        int square = sortedNums[currIndex] * sortedNums[currIndex];
        int searchResult = Arrays.binarySearch(sortedNums, square);
        if (searchResult > -1 && !visited[searchResult]) {
            dfs(searchResult, currCount + 1);
        }

        if (max < currCount) {
            max = currCount;
        }
    }
}
