class Solution {
    private boolean[] prime;
    private TreeSet<Integer> primeSet;

    public boolean primeSubOperation(int[] nums) {
        prime = new boolean[1001];
        primeSet = new TreeSet<>();
        for (int i = 2; i <= 1000; i++) {
            if (prime[i]) {
                continue;
            }
            primeSet.add(i);
            for (int j = i * 2; j <= 1000; j += i) {
                prime[j] = true;
            }
        }

        int size = nums.length;
        for (int i = size - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                continue;
            }

            // nums[i] >= nums[i+1]
            Integer upperBound = primeSet.ceiling(nums[i] - nums[i + 1] + 1);
            if (upperBound == null || upperBound >= nums[i]) {
                return false;
            }
            nums[i] -= upperBound;
            if (nums[i] < 0) {
                return false;
            }
        }
        return true;
    }
}