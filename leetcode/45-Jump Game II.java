// 84ms. 한번에 풀긴 했는데 최적은 아니고.. 그리디 알고리즘을 쓰는게 제일 좋다. 다음에 다시 풀어봐야함
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int[] visitCount = new int[length];
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        Arrays.fill(visitCount, 1, length, Integer.MAX_VALUE);
        queue.offer(getPath(0, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();

            int currIndex = curr.getKey();
            int currCount = curr.getValue();
            int num = nums[currIndex];
            for (int i = 1; i <= num; i++) {
                if (currIndex + i >= length || currCount + 1 >= visitCount[currIndex + i]) {
                    continue;
                }
                visitCount[currIndex + i] = currCount + 1;
                queue.offer(getPath(currIndex + i, currCount + 1));
            }
        }

        return visitCount[length-1];
    }

    private Pair<Integer, Integer> getPath(int index, int move) {
        return new Pair<>(index, move);
    }
}
