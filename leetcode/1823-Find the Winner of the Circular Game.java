class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }

        while (deque.size() > 1) {
            for (int j = 1; j < k; j++) {
                deque.offerLast(deque.pollFirst());
            }
            deque.pollFirst();
        }

        return deque.pollFirst();
    }
}
