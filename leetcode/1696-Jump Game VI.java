/**
 * 86ms. 진짜 힘들었다.. monotonic queue 더 공부해야할듯
 */
class Solution {
    public int maxResult(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        int[] dp = new int[length];
        dp[length-1] = nums[length-1];
        pq.offer(new Pair<>(length-1, dp[length-1]));
        for (int i = length-2; i >= 0; i--) {
            while (!pq.isEmpty() && pq.peek().getKey() > i+k) {
                pq.poll();
            }

            dp[i] = nums[i] + pq.peek().getValue();
            pq.offer(new Pair<>(i, dp[i]));
        }

        return dp[0];
    }
}