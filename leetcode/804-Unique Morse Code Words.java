// 2ms. 이제 이지 난이도는 데일리만 풀어도 될듯..
class Solution {
    private String[] alphabet = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> morseCodes = new HashSet<>();
        for (String word : words) {
            morseCodes.add(transform(word));
        }
        return morseCodes.size();
    }

    private String transform(String word) {
        StringBuilder sb = new StringBuilder();
        char[] cs = word.toCharArray();
        for (char c : cs) {
            sb.append(alphabet[c - 'a']);
        }
        return sb.toString();
    }
}
