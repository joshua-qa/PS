import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs).toString());
    }

    /**
     * 풀고나서 솔루션을 보고 미흡한 부분만 개선해본 것. 10ms가 나왔다.
     */
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

    /**
     * 처음 풀었을 때 코드. 솔루션을 올바르게 생각해낸 것은 좋으나, 부수적인 처리가 미흡하여 32ms가 나왔다..
     */
    public List<List<String>> groupAnagrams_origin(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagramListMap = new HashMap<>();
        for (String str : strs) {
            String anagramInfo = getAnagramInfo(str.toCharArray());

            List<String> temp = anagramListMap.containsKey(anagramInfo) ? anagramListMap.get(anagramInfo) : new ArrayList<>();
            temp.add(str);
            anagramListMap.put(anagramInfo, temp);
        }
        for (String key : anagramListMap.keySet()) {
            result.add(anagramListMap.get(key));
        }
        return result;
    }

}
