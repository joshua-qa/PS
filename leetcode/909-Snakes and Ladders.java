// 43ms. 굳이 이런걸 데일리로 냈어야 하나.. 라는 생각을 많이 하게 된다.
class Solution {
    private Queue<Pair<Integer, Integer>> queue;
    private int[][] visit;
    private int size, endX, endY, end;
    public int snakesAndLadders(int[][] board) {
        queue = new ArrayDeque<>();
        size = board.length;
        visit = new int[size][size];

        endX = 0;
        endY = 0;
        end = size * size;
        int result = 987654321;
        if ((size & 1) == 1) {
            endY = size-1;
        }

        for (int i = 0; i < size; i++) {
            Arrays.fill(visit[i], 987654321);
        }
        visit[size-1][0] = 0;

        // key : board number, value : visit count
        queue.offer(new Pair<>(1, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            int currNum = curr.getKey();
            int currVisit = curr.getValue();
            int rangeNum = getRange(currNum);
            if (currNum == end) {
                result = Math.min(result, currVisit);
                continue;
            }

            for (int i = currNum+1; i <= rangeNum; i++) {
                Pair<Integer, Integer> nextPosition = getPosition(i);
                int nextInfo = board[nextPosition.getKey()][nextPosition.getValue()];
                if (nextInfo != -1) {
                    nextPosition = getPosition(nextInfo);
                }

                if (currVisit+1 >= visit[nextPosition.getKey()][nextPosition.getValue()]) {
                    continue;
                }

                visit[nextPosition.getKey()][nextPosition.getValue()] = currVisit+1;
                if (nextInfo != -1) {
                    queue.offer(new Pair<>(nextInfo, currVisit+1));
                } else {
                    queue.offer(new Pair<>(i, currVisit+1));
                }
            }
        }
        return result == 987654321 ? -1 : result;
    }

    private int getRange(int curr) {
        return Math.min(curr+6, end);
    }

    private Pair<Integer, Integer> getPosition(int number) {
        number--;
        int x = number / size;
        if ((x & 1) == 1) {
            return new Pair<>((size-1) - x, (size-1) - (number%size));
        }
        return new Pair<>((size-1) - x, number % size);
    }
}
