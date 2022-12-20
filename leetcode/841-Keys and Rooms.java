// 1ms. 이지보다 쉬운 미디엄인듯. 심지어 BFS 돌리기 편하게 rooms가 제공됨
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int length = rooms.size();
        boolean[] visited = new boolean[length];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : rooms.get(curr)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.offer(next);
            }
        }

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
