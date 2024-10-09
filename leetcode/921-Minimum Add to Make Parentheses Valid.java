class Solution {
    public int minAddToMakeValid(String s) {
        char[] paren = s.toCharArray();
        int size = paren.length;
        int result = 0;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            if (paren[i] == '(') {
                stack.offerLast(paren[i]);
                continue;
            }

            // paren[i] == ')'
            if (stack.isEmpty()) {
                result++;
            } else {
                stack.pollLast();
            }
        }

        return result + stack.size();
    }
}
