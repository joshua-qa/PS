// 81ms. compare 메서드를 평소처럼 작성했다가 엣지 케이스에서 틀렸다.. 앞으로는 작성 방식을 바꿔야겠음.
class Solution {
    public int findMinArrowShots(int[][] points) {
        Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        int length = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return -1;
                } else if (o1[1] == o2[1]) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        int count = 0;
        for (int[] point : points) {
            if (stack.isEmpty()) {
                count++;
                stack.push(new Pair<>(point[0], point[1]));
                continue;
            }

            Pair<Integer, Integer> peek = stack.peek();

            stack.poll();
            if (point[0] <= peek.getValue()) {
                stack.push(new Pair<>(point[0], peek.getValue()));
                continue;
            }

            count++;
            stack.push(new Pair<>(point[0], point[1]));
        }
        return count;
    }
}
