class Solution {
    /**
     * O(N)
     * 무조건 한칸은 건너 띄워야함
     * 그리고 두칸 스킵하고 이번꺼 터는 케이스도 고려해야함
     * Runtime:0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage:38.2 MB, less than 13.97% of Java online submissions.
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int result = nums[0];
        int[] dp = new int[length+1];
        dp[1] = nums[0];
        if (length > 1) {
            if (nums[0] > nums[1]) {
                dp[2] = nums[0];
            } else {
                dp[2] = nums[1];
                result = nums[1];
            }
        }
        for (int i = 3; i <= length; i++) {
            int rob = Math.max(dp[i-3], dp[i-2]) + nums[i-1];
            int skip = Math.max(dp[i-2], dp[i-1]);
            dp[i] = Math.max(rob, skip);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}