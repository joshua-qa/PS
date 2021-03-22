import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int index = 0;
        for (int[] command : commands) {
            List<Integer> temp = new ArrayList<>();
            for (int i = command[0] - 1; i < command[1]; i++) {
                temp.add(array[i]);
            }
            Collections.sort(temp);
            answer[index++] = temp.get(command[2]-1);
        }
        return answer;
    }
}