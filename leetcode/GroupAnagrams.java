import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs).toString());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramListMap = new HashMap<>();
        for (String str : strs) {
            String anagramInfo = getAnagramInfo(str.toCharArray());

            if (!anagramListMap.containsKey(anagramInfo)) {
                anagramListMap.put(anagramInfo, new ArrayList<>());
            }
            anagramListMap.get(anagramInfo).add(str);
        }
        return new ArrayList<>(anagramListMap.values());
    }

    private String getAnagramInfo(char[] currentStr) {
        int[] alphabetCount = new int[26];
        for (char c : currentStr) {
            alphabetCount[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabetCount.length; i++) {
            sb.append(alphabetCount[i]);
        }
        return sb.toString();
    }
}
