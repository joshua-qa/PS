import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        int[] arr = {1,2,3};
        int[] arr2 = {1,1,3,3,5,5,7,7};
        int[] arr3 = {1,3,2,3,5,0};
        int[] arr4 = {1,1,2,2};
        System.out.println(countElements(arr));
        System.out.println(countElements(arr2));
        System.out.println(countElements(arr3));
        System.out.println(countElements(arr4));
    }

    // 첫 풀이 5ms
    public int countElementsFirstTry(int[] arr) {
        int result = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : arr) {
            if (numCount.containsKey(num)) {
                numCount.put(num, numCount.get(num) + 1);
            } else {
                numCount.put(num, 1);
            }
        }

        for (int key : numCount.keySet()) {
            if (numCount.containsKey(key + 1)) {
                result += numCount.get(key);
            }
        }
        return result;
    }

    // 풀고나서 발상 떠올라서 바로 재시도 2ms
    public static final int MAX = 1000;
    public int countElementsSecondTry(int[] arr) {
        int result = 0;
        int[] count = new int[MAX + 1];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 0; i < MAX; i++) {
            if (count[i+1] != 0) {
                result += count[i];
            }
        }
        return result;
    }

    // 문제에 주어진 힌트 보고 3번째 시도 1ms
    public int countElements(int[] arr) {
        int result = 0;
        int[] count = new int[MAX + 2];
        Set<Integer> numSet = new HashSet<>(MAX);
        for (int num : arr) {
            count[num]++;
            numSet.add(num);
        }
        for (int i : numSet) {
            if (count[i+1] != 0) {
                result += count[i];
            }
        }
        return result;
    }
}
