import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        int example = 19;
        int example2 = 2000000000;
        System.out.println(isHappy(example));
        System.out.println(isHappy(example2));
    }

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int current = n;
        Map<Integer, Boolean> countMap = new HashMap<>();
        countMap.put(current, true);

        while (true) {
            current = getSumBySquare(current);
            if (current == 1) {
                return true;
            }
            if (countMap.containsKey(current)) {
                return false;
            }
            countMap.put(current, true);
        }
    }

    private int getSumBySquare(int currentNumber) {
        int sum = 0;
        for(int i = 10; currentNumber > 0; currentNumber /= 10) {
            int digit = currentNumber % i;
            currentNumber -= digit;
            sum += (digit * digit);
        }
        return sum;
    }
}
