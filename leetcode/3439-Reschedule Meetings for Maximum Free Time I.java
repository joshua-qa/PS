class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int length = startTime.length;
        int[][] table = new int[length+2][2];
        table[length+1][0] = eventTime;
        table[length+1][1] = eventTime;
        for (int i = 0; i < length; i++) {
            table[i+1][0] = startTime[i];
            table[i+1][1] = endTime[i];
        }

        Deque<int[]> queue = new ArrayDeque<>();
        length = table.length;
        int freeTime = 0, max = 0;
        for (int i = 0; i < length; i++) {
            if (queue.isEmpty()) {
                queue.offerLast(table[i]);
                continue;
            }
            if (queue.size() < k+2) {
                // calculate
                int[] peekLast = queue.peekLast();
                freeTime += (table[i][0] - peekLast[1]);
            } else {
                // else -> queue.size() == k+2
                int[] pollFirst = queue.pollFirst();
                int[] peekFirst = queue.peekFirst();
                freeTime -= (peekFirst[0] - pollFirst[1]);
                int[] peekLast = queue.peekLast();
                freeTime += (table[i][0] - peekLast[1]);
            }

            max = max < freeTime ? freeTime : max;
            queue.offerLast(table[i]);
        }
        return max;
    }
}
