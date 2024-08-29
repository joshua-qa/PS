class Solution {
    private int width, height;
    private int[] union;
    private List<Integer>[] horizontal;
    private List<Integer>[] vertical;
    public int removeStones(int[][] stones) {
        // union find
        // 일치하는 그룹끼리 합친 뒤 (전체 갯수 - 그룹 갯수)로 정답 리턴하면 됨
        for (int[] stone : stones) {
            width = Math.max(width, stone[1]);
            height = Math.max(height, stone[0]);
        }

        width++;
        height++;

        union = new int[stones.length];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }

        horizontal = new ArrayList[height];
        vertical = new ArrayList[width];
        for (int i = 0; i < height; i++) {
            horizontal[i] = new ArrayList<>();
        }

        for (int i = 0; i < width; i++) {
            vertical[i] = new ArrayList<>();
        }

        // stone[0] = x (height), stone[1] = y (width)
        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            horizontal[stone[0]].add(i);
            vertical[stone[1]].add(i);
        }

        for (int i = 0; i < height; i++) {
            if (horizontal[i].isEmpty()) {
                continue;
            }

            // horizontal에 들어있는 것중 첫번째를 지목하고 하나씩 탐색
            // 현재 stone을 지목해놓은 첫번째에 합치고, 각자 해당하는 vertical을 탐색해서 다 합치기
            int firstStone = horizontal[i].get(0);
            for (int currStone : horizontal[i]) {
                merge(currStone, firstStone);
                int currWidth = stones[currStone][1];
                for (int widthStone : vertical[currWidth]) {
                    merge(widthStone, firstStone);
                }
            }
        }

        Set<Integer> groups = new HashSet<>();
        for (int i = 0; i < union.length; i++) {
            int parent = find(i);
            groups.add(parent);
        }

        return stones.length - groups.size();
    }

    private int find(int n) {
        if (union[n] == n) {
            return n;
        }
        union[n] = find(union[n]);
        return union[n];
    }

    private void merge(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        union[b] = a;
    }
}
