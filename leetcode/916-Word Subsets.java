// 15ms. faster than 96.34% 체감 굿 ㅋㅋ Arrays.copyOf는 내 생각보다 훨씬 빠른 메서드였다...
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] merge = new int[26];
        for (String word : words2) {
            int size = word.length();
            int[] count = new int[26];
            for (int i = 0; i < size; i++) {
                count[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                merge[i] = merge[i] >= count[i] ? merge[i] : count[i];
            }
        }
        for (String word : words1) {
            int size = word.length();
            int[] count = Arrays.copyOf(merge, 26);
            for (int i = 0; i < size; i++) {
                count[word.charAt(i) - 'a']--;
            }
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(word);
            }
        }
        return result;
    }
}
