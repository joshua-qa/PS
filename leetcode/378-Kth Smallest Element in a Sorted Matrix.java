// 28ms. 제대로 접근해서 풀려면 상당히 어렵고, 많이 공부해야되는 문제다. 그리고 O(N)은 논문을 이해해야 가능한거였음..
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) {
            return matrix[0][0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}
