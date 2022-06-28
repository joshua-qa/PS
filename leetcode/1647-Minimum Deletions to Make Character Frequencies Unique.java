/**
 * 13ms. 풀이가 한번에 생각나서 만족
 */
class Solution {
    public int minDeletions(String s) {
        int result = 0;
        int[] count = new int[26];
        Map<Integer, Integer> countTable = new HashMap<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            count[c - 'a']++;
        }

        for (int i : count) {
            countTable.put(i, countTable.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < 26; i++) {
            int currSameCount = countTable.get(count[i]);
            if (currSameCount == 1) {
                continue;
            }

            int key = count[i];
            while (key > 0) {
                key--;
                result++;
                if (countTable.getOrDefault(key, 0) == 0) {
                    countTable.put(key, 1);
                    break;
                }
            }
            countTable.put(count[i], currSameCount-1);
        }

        return result;
    }
}