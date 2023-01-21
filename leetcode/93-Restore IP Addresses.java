// 5ms. 올바른 IP 주소 규칙을 어떻게 validation 할 것인지, 그리고 backtracking을 할 줄 아는지에 따라 체감 난이도가 달라질듯.
class Solution {
    private List<String> result;
    private String numbers;
    private int length;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        length = s.length();
        if (length < 4 || length > 12) {
            return result;
        }
        numbers = s;
        dfs("", 0, 0);
        return result;
    }

    private void dfs(String curr, int currIndex, int currPart) {
        if (currPart == 4) {
            if (currIndex == length) {
                result.add(curr);
            }
            return;
        }

        for (int i = currIndex; i < currIndex+3; i++) {
            if (i >= length) {
                break;
            }
            String part = numbers.substring(currIndex, i+1);
            if (isAvailable(part)) {
                String next = (currPart == 0) ? part : curr + "." + part;
                dfs(next, i+1, currPart+1);
            }
        }
    }

    private boolean isAvailable(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }
        int value = Integer.parseInt(part);
        return value >= 0 && value <= 255;
    }
}

