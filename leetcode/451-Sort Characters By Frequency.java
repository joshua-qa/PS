// 4ms. Comparator 만들 때 람다식 일부러 안썼는데 그래서 빠른 듯
class Solution {
    public String frequencySort(String s) {
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        List<Pair<Character, Integer>> countPairs = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            if (count != 0) {
                countPairs.add(new Pair<>((char) i, count));
            }
        }
        countPairs.sort(new Comparator<Pair<Character, Integer>>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder result = new StringBuilder();
        for (Pair<Character, Integer> countPair : countPairs) {
            char key = countPair.getKey();
            int frequency = countPair.getValue();
            for (int i = 0; i < frequency; i++) {
                result.append(key);
            }
        }
        return result.toString();
    }
}
