class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Character>>() {
            @Override
            public int compare(Pair<Integer, Character> o1, Pair<Integer, Character> o2) {
                return o2.getKey() - o1.getKey();
            }
        });
        int total = a + b + c;
        pq.offer(new Pair<>(a, 'a'));
        pq.offer(new Pair<>(b, 'b'));
        pq.offer(new Pair<>(c, 'c'));

        StringBuilder sb = new StringBuilder();
        while (true) {
            Pair<Integer, Character> max = pq.poll();
            Pair<Integer, Character> mid = pq.poll();
            if (max.getKey() == 0) {
                break;
            }

            int maxCount = (max.getKey() > 1) ? 2 : 1;
            if (sb.length() > 0 && max.getValue() == sb.charAt(sb.length() - 1)) {
                maxCount = 1;
            }
            for (int i = 0; i < maxCount; i++) {
                sb.append(max.getValue());
            }
            total -= maxCount;

            if (mid.getKey() == 0) {
                break;
            }
            pq.offer(new Pair<>(max.getKey() - maxCount, max.getValue()));

            int midCount = (total - mid.getKey()) > mid.getKey() || mid.getKey() == 1 ? 1 : 2;
            for (int i = 0; i < midCount; i++) {
                sb.append(mid.getValue());
            }
            total -= midCount;
            pq.offer(new Pair<>(mid.getKey() - midCount, mid.getValue()));
        }

        return sb.toString();
    }
}
