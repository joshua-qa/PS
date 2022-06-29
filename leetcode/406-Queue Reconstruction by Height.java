/**
 * 23ms.. move 때문에 느린거라서 linked list를 써야 더 깔끔하게 나온다.
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int[][] result = new int[people.length][2];
        int currSize = 0;
        for (int[] curr : people) {
            int height = curr[0];
            int higherPeopleCount = curr[1];

            int i = 0;
            for (; i < currSize; i++) {
                // 현재 보고 있는게 넣어야할 것보다 큰 경우
                if (result[i][0] >= height) {
                    if (higherPeopleCount != 0) {
                        higherPeopleCount--;
                        continue;
                    }
                    break;
                }
            }
            // move
            move(result, i, currSize-1);
            result[i][0] = curr[0];
            result[i][1] = curr[1];
            // insert
            currSize++;
        }

        return result;
    }

    private int[][] move(int[][] result, int start, int end) {
        for (int i = end; i >= start; i--) {
            result[i+1][0] = result[i][0];
            result[i+1][1] = result[i][1];
        }
        return result;
    }
}