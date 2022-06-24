class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        int currentSum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : target) {
            currentSum += num;
            queue.offer(num);
        }
        while (!queue.isEmpty() && queue.peek() != 1) {
            int current = queue.poll();
            int nextSum = currentSum - current;
            if (nextSum == 1) {
                currentSum -= (current-1);
                current = 1;
            } else {
                if (current == nextSum) {
                    return false;
                }
                int mod = current % nextSum;
                if (mod == 0 || mod == current) {
                    return false;
                }
                currentSum -= (current - mod);
                current = mod;
            }
            queue.offer(current);
        }
        return true;
    }
}
