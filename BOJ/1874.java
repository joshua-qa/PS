package Joshua.PS.BOJ;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jgchoi.qa on 2017. 3. 14..
 */
public class Main {
    private static void Sequence(int[] array, int N) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack();
        int i = 2;
        int current = 0;
        int max = 1;
        stack.push(1);
        sb.append("+\n");

        while(max < N*2) {
            if(max >= N*2) {
                break;
            }
            if((stack.empty() || stack.peek() != array[current]) && i <= N) {
                stack.push(i);
                sb.append("+\n");
                i++;
            } else if (stack.peek() == array[current]) {
                System.out.println(stack.pop());
                sb.append("-\n");
                current++;
            }
            max++;
        }

        if (!stack.empty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] expectedResult = new int[N];

        for (int a = 0; a < expectedResult.length; a++) {
            expectedResult[a] = scan.nextInt();
        }

        Sequence(expectedResult, N);
    }
}