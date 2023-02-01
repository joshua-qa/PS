// 3ms. 미디엄에 가깝지 않나..
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str1;
        }

        int result = 0;
        int str1Length = str1.length();
        int str2Length = str2.length();
        int maxGcdLength = str1Length > str2Length ? str2Length: str1Length;
        for (int i = 1; i <= maxGcdLength; i++) {
            String curr = str1.substring(0, i);
            int currLength = curr.length();
            if (str1Length % currLength != 0 || str2Length % currLength != 0) {
                continue;
            }

            if (str1.startsWith(curr) && str2.startsWith(curr) && str1.endsWith(curr) && str2.endsWith(curr) && isAvailable(curr, str1) && isAvailable(curr, str2)) {
                result = currLength;
            }
        }

        return str1.substring(0, result);
    }

    private boolean isAvailable(String curr, String target) {
        StringBuilder sb = new StringBuilder();
        int div = target.length() / curr.length();
        for (int i = 0; i < div; i++) {
            sb.append(curr);
        }
        return sb.toString().equals(target);
    }
}
