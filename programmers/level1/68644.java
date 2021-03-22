import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[result.size()];
        int index = 0;
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            answer[index++] = iterator.next();
        }
        Arrays.sort(answer);
        return answer;
    }
}