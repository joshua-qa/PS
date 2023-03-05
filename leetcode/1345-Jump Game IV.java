// 173ms. 계속 TLE가 나와서 자력으로 풀진 못했다. 딱 한줄 더 추가하니까 맞았다.
// 한번 탐색한 곳을 다시 들를 필요가 없는데 노드를 삭제하지 않고 이동수를 DP 배열로 만들어서 관리하려고 한게 원인이었다.
class Solution {
    private Map<Integer, TreeSet<Integer>> nums;
    private Queue<Pair<Integer, Integer>> queue;
    private int[] move;
    private int result, length;
    public int minJumps(int[] arr) {
        nums = new HashMap<>();
        queue = new ArrayDeque<>();
        length = arr.length;
        if (length == 1) {
            return 0;
        }
        move = new int[length];
        Arrays.fill(move, 1, length, length);
        for (int i = 0; i < length; i++) {
            if (!nums.containsKey(arr[i])) {
                nums.put(arr[i], new TreeSet<>(Comparator.reverseOrder()));
            }
            nums.get(arr[i]).add(i);
        }

        result = length-1;

        bfs(arr);
        return result;
    }

    private void bfs(int[] arr) {
        queue.offer(new Pair<>(0, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            int index = curr.getKey();
            int moveCount = curr.getValue();
            if (moveCount > result) {
                continue;
            }

            if (index == length-1) {
                result = Math.min(moveCount, result);
                continue;
            }

            if (index-1 > 0 && moveCount+1 < move[index-1]) {
                move[index-1] = moveCount+1;
                queue.offer(new Pair<>(index-1, moveCount+1));
            }
            if (index+1 < length && moveCount+1 < move[index+1]) {
                move[index+1] = moveCount+1;
                queue.offer(new Pair<>(index+1, moveCount+1));
            }

            for (int next : nums.get(arr[index])) {
                if (move[next] < moveCount+1) {
                    continue;
                }

                move[next] = moveCount+1;
                queue.offer(new Pair<>(next, moveCount+1));
            }
            nums.get(arr[index]).clear();
        }
    }
}
