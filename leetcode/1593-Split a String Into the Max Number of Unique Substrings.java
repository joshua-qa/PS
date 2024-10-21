class Solution {
    private int max, length;

    public int maxUniqueSplit(String s) {
        // backtracking
        length = s.length();
        Set<String> substrings = new HashSet<>();
        splitAndCheck(s, substrings, 0);
        return max;
    }

    private void splitAndCheck(String s, Set<String> substrings, int currIndex) {
        if (length == currIndex) {
            if (max < substrings.size()) {
                max = substrings.size();
            }
            return;
        }

        for (int i = currIndex; i < length; i++) {
            String currSubstring = s.substring(currIndex, i + 1);
            if (substrings.contains(currSubstring)) {
                continue;
            }

            substrings.add(currSubstring);
            splitAndCheck(s, substrings, i + 1);
            substrings.remove(currSubstring);
        }
    }
}
