class Solution {
    public int minGroups(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            if (max < interval[1]) {
                max = interval[1];
            }
        }
        int[] prefixSum = new int[max+2];

        for (int[] interval : intervals) {
            prefixSum[interval[0]]++;
            prefixSum[interval[1]+1]--;
        }

        int min = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + prefixSum[i];
            if (prefixSum[i] > min) {
                min = prefixSum[i];
            }
        }
        return min;
    }
}
