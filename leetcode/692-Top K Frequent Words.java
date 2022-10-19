// 6ms. 미디엄 치고는 너무 쉬운데..
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            pq.offer(new Pair<>(entry.getKey(), entry.getValue()));
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().getKey());
        }
        return result;
    }
}
