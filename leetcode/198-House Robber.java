// 0ms. 네줄로 푼 사람 있던데 조금 신기했다.
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length+1];
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        dp[1] = nums[0];
        dp[2] = nums[1];
        for (int i = 3; i <= length; i++) {
            dp[i] = Math.max(dp[i-3], dp[i-2]) + nums[i-1];
        }

        return Math.max(dp[length-1], dp[length]);
    }
}
