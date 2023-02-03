// 8ms. 익숙한 느낌의 문제..
class Solution {
    public String convert(String s, int numRows) {
        char[] cs = s.toCharArray();
        Queue<Character>[] queues = new ArrayDeque[numRows];
        for (int i = 0; i < numRows; i++) {
            queues[i] = new ArrayDeque<>();
        }

        for (int i = 0, j = 0, flag = 1; i < cs.length; i++) {
            queues[j].offer(cs[i]);

            if (numRows == 1) {
                continue;
            }
            if ((j == 0 && flag == -1) || (j == numRows-1 && flag == 1)) {
                flag = -flag;
            }
            j += flag;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            while (!queues[i].isEmpty()) {
                sb.append(queues[i].poll());
            }
        }
        return sb.toString();
    }
}
