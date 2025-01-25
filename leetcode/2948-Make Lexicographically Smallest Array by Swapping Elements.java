class Solution {
    private int[] group;
    private Pair[] pairs;
    private int n;
    private Map<Integer, List<Pair>> groupMap;

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        n = nums.length;
        pairs = new Pair[n];
        group = new int[n];
        groupMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            group[i] = i;
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        });

        int currGroup = 0;
        List<Pair> currGroupPairs = new ArrayList<>();
        currGroupPairs.add(pairs[0]);
        groupMap.put(currGroup, currGroupPairs);

        for (int i = 0; i < n - 1; i++) {
            if (abs(pairs[i].value, pairs[i + 1].value) <= limit) {
                union(currGroup, i + 1);
            } else {
                currGroup = i + 1;
                List<Pair> nextGroupPairs = new ArrayList<>();
                nextGroupPairs.add(pairs[i + 1]);
                groupMap.put(currGroup, nextGroupPairs);
            }
        }

        // 원래 인덱스에 배치하기
        int[] result = new int[n];
        for (int groupKey : groupMap.keySet()) {
            List<Pair> currPairs = groupMap.get(groupKey);
            int pairSize = currPairs.size();

            if (pairSize == 1) {
                result[currPairs.get(0).index] = currPairs.get(0).value;
                continue;
            }

            int[] indices = new int[pairSize];
            for (int i = 0; i < pairSize; i++) {
                indices[i] = currPairs.get(i).index;
            }

            Arrays.sort(indices);

            for (int i = 0; i < pairSize; i++) {
                result[indices[i]] = currPairs.get(i).value;
            }
        }

        return result;
    }

    private int abs(int a, int b) {
        int result = a - b;
        return result < 0 ? -result : result;
    }

    private void union(int a, int b) {
        int groupA = find(a);

        group[b] = groupA;
        groupMap.get(a).add(pairs[b]);
    }

    private int find(int a) {
        if (group[a] == a) {
            return a;
        }

        return group[a] = find(group[a]);
    }
}

class Pair {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value=" + value +
                ", index=" + index +
                '}';
    }
}