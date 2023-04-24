// 1ms. 알고보니 3년전 이맘때에도 풀었던 문제였다.
class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int remain = first - second;
            if (remain > 0) {
                pq.offer(remain);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
