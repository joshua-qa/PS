// 43ms. 의외로 날먹 가능
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int absA = Math.abs(o1 - x);
                int absB = Math.abs(o2 - x);
                if (absA == absB) {
                    return o1 - o2;
                }
                return absA - absB;
            }
        };

        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for (int num : arr) {
            queue.offer(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }
        Collections.sort(result);
        return result;
    }
}
