// 9ms. bfs가 풀기 쉬움
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> numberQueue = new LinkedList<>();
        Set<Integer> resultSet = new HashSet<>();
        int target = (int) Math.pow(10, n-1);

        for (int i = 1; i < 10; i++) {
            numberQueue.offer(i);
        }

        while (!numberQueue.isEmpty()) {
            int curr = numberQueue.poll();

            if (curr >= target) {
                resultSet.add(curr);
                continue;
            }

            int lastNum = curr % 10;
            if (lastNum + k < 10) {
                numberQueue.offer(curr * 10 + (lastNum + k));
            }
            if (lastNum - k >= 0) {
                numberQueue.offer(curr * 10 + (lastNum - k));
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        return result;
    }
}
