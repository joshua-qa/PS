// 72ms. 수학적인 풀이가 혹시 가능하지 않을까 상상만 했는데 다른 사람들 풀이 보니까 진짜였네..
class Solution {
    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int[] dp = new int[n+1];
        Arrays.fill(dp, 10001);
        int count = 10001;
        queue.offer(create(0, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();

            if (curr.getKey() == n) {
                count = Math.min(count, curr.getValue());
                continue;
            }
            int currCount = curr.getValue();
            if (currCount >= count) {
                continue;
            }
            int remain = n - curr.getKey();

            for (int i = 1; i*i <= remain; i++) {
                int currNum = curr.getKey() + (i * i);
                if (dp[currNum] <= currCount+1) {
                    continue;
                }
                dp[currNum] = currCount+1;
                queue.offer(create(currNum, currCount+1));
            }
        }
        return count;
    }

    private Pair<Integer, Integer> create(int num, int count) {
        return new Pair<>(num, count);
    }
}
