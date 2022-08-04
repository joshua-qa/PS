// 8ms. 쉬운 방법으로 접근함.
class Solution {
    String[] phone;
    List<String> result;
    public List<String> letterCombinations(String digits) {
        int size = digits.length();
        result = new ArrayList<>();
        if (size == 0) {
            return result;
        }
        init();
        dfs(digits.toCharArray(), "", 0);
        return result;
    }

    private void init() {
        phone = new String[10];
        phone[2] = "abc";
        phone[3] = "def";
        phone[4] = "ghi";
        phone[5] = "jkl";
        phone[6] = "mno";
        phone[7] = "pqrs";
        phone[8] = "tuv";
        phone[9] = "wxyz";
    }

    private void dfs(char[] digits, String curr, int index) {
        if (index == digits.length) {
            result.add(curr);
            return;
        }

        char[] alphabets = phone[digits[index] - '0'].toCharArray();
        for (char alphabet : alphabets) {
            dfs(digits, curr + alphabet, index+1);
        }
    }
}
