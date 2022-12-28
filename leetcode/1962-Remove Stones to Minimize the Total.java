// 711ms. 자바로 풀면 얼마나 오래 걸리는지 이게 faster than 66.52%...
// 직접 힙 구현해서 풀면 훨씬 낫긴 할듯
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            pq.offer(pile);
        }

        for (int i = 0; i < k; i++) {
            int pollValue = pq.poll();
            pq.offer(pollValue - (pollValue / 2));
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        return result;
    }
}
