class Solution {
    public long maxKelements(int[] nums, int k) {
        // greedy + pq
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, Comparator.reverseOrder());
        long result = 0;

        for (int num : nums) {
            pq.offer(num);
        }

        for (int i = 0; i < k; i++) {
            int curr = pq.remove();
            result += curr;

            pq.offer(ceil(curr));
        }

        return result;
    }

    private int ceil(int num) {
        if (num % 3 == 0) {
            return num / 3;
        }
        return (num / 3) + 1;
    }
}
