// 12ms. 어렵게 생각할뻔했지만... 규칙을 잘 살펴보면 미디엄인 이유를 알 수 있다.
class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int[] word1Count = new int[26];
        int[] word2Count = new int[26];
        boolean[] alphabetVisit = new boolean[26];
        for (char c : word1.toCharArray()) {
            int index = c - 'a';
            word1Count[index]++;
            if (!alphabetVisit[index]) {
                alphabetVisit[index] = true;
            }
        }
        for (char c : word2.toCharArray()) {
            int index = c - 'a';
            word2Count[index]++;
            if (!alphabetVisit[index]) {
                return false;
            }
        }

        for (int i = 0; i < 26; i++) {
            int prev = countMap.getOrDefault(word1Count[i], 0);
            countMap.put(word1Count[i], prev + 1);
        }
        for (int i = 0; i < 26; i++) {
            int curr = countMap.getOrDefault(word2Count[i], 0);
            if (curr <= 0) {
                return false;
            }
            countMap.put(word2Count[i], curr-1);
        }
        return true;
    }
}
