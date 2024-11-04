class Solution {
    public String compressedString(String word) {
        char[] cs = word.toCharArray();
        StringBuilder sb = new StringBuilder();

        int index = 0, currCount = 0;
        int size = cs.length;
        while (index != size) {
            char curr = cs[index];
            while (index < size && curr == cs[index]) {
                currCount++;
                index++;
            }

            while (currCount > 9) {
                sb.append(9).append(curr);
                currCount -= 9;
            }
            if (currCount != 0) {
                sb.append(currCount).append(curr);
                currCount = 0;
            }
        }

        return sb.toString();
    }
}
