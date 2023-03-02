// 1ms. 솔직히 좀 화딱지나는 문제였는데 아니나다를까 비추가 추천보다 많았다.
class Solution {
    public int compress(char[] chars) {
        int writeIndex = 0;
        int currLength = 0;
        int findIndex = 0;

        while (findIndex < chars.length) {
            char c = chars[findIndex];
            currLength = 1;
            while (findIndex < chars.length-1 && c == chars[findIndex+1]) {
                findIndex++;
                currLength++;
            }
            chars[writeIndex] = c;
            if (currLength == 1) {
                writeIndex++;
                findIndex++;
                continue;
            }
            String lengthText = String.valueOf(currLength);
            for (int i = 0; i < lengthText.length(); i++) {
                chars[++writeIndex] = lengthText.charAt(i);
            }
            writeIndex++;
            findIndex++;
        }
        return writeIndex;
    }
}
