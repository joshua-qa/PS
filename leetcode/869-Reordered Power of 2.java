// 7ms. 배열로 했으면 시간은 더 줄일 수 있을듯
class Solution {
    public boolean reorderedPowerOf2(int n) {
        List<Map<Integer, Integer>> countMaps = new ArrayList<>();
        for (int i = 1; i <= 1000000000; i = i << 1) {
            countMaps.add(getCountMap(i));
        }

        Map<Integer, Integer> inputNumberCountMap = getCountMap(n);
        Set<Map.Entry<Integer, Integer>> countMapEntrySet = inputNumberCountMap.entrySet();
        for (Map<Integer, Integer> countMap : countMaps) {
            if (countMap.size() != inputNumberCountMap.size()) {
                continue;
            }
            boolean isReorderable = true;
            for (Map.Entry<Integer, Integer> entry : countMapEntrySet) {
                if (!countMap.getOrDefault(entry.getKey(), 0).equals(entry.getValue())) {
                    isReorderable = false;
                }
            }
            if (isReorderable) {
                return true;
            }
        }
        return false;
    }

    private Map<Integer, Integer> getCountMap(int n) {
        Map<Integer, Integer> count = new HashMap<>();
        while (n > 0) {
            int mod = n % 10;
            count.put(mod, count.getOrDefault(mod, 0) + 1);
            n /= 10;
        }
        return count;
    }
}
