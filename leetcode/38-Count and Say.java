// 2ms. n제한이 빡세지 않아서 쉬웠다. 낚여서 틀린 사람이 많은지 비추가 많았음.
class Solution {
    public String countAndSay(int n) {
        return process(n-1, "1");
    }

    private String process(int remain, String text) {
        if (remain == 0) {
            return text;
        }

        StringBuilder sb = new StringBuilder();
        int prev = text.charAt(0) - '0';
        int count = 1;
        int length = text.length();
        for (int i = 1; i < length; i++) {
            int curr = text.charAt(i) - '0';
            if (curr == prev) {
                count++;
            } else {
                sb.append(count).append(prev);
                prev = curr;
                count = 1;
            }
        }
        sb.append(count).append(prev);
        return process(remain-1, sb.toString());
    }
}
