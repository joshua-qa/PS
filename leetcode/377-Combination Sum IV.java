// 5ms. 무난함
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums[0] > target) {
            return 0;
        }

        int[] dp = new int[target+1];
        int length = nums.length;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[j] > i) {
                    break;
                }
                int prev = i - nums[j];
                if (prev < 0) {
                    continue;
                }
                if (prev == 0) {
                    dp[i]++;
                    continue;
                }
                dp[i] += dp[prev];
            }
        }
        return dp[target];
    }
}
