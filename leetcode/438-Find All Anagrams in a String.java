// 6ms. 어제랑 똑같은 유형인데 잔실수가 많이 나오는걸 보니 연습좀 해두면 좋을듯
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        if (pLength > sLength) {
            return result;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLength; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (isAnagram(sCount, pCount)) {
            result.add(0);
        }

        for (int i = 1, j = pLength; j < sLength; i++, j++) {
            sCount[s.charAt(i-1) - 'a']--;
            sCount[s.charAt(j) - 'a']++;
            if (isAnagram(sCount, pCount)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAnagram(int[] sCount, int[] pCount) {
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != pCount[i]) {
                return false;
            }
        }
        return true;
    }
}
