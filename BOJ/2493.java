import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> indexStack = new Stack<>();
    private static int currTower;
    public static void main(String[] args) throws IOException, NumberFormatException {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextInt());
        StringBuffer sb = new StringBuffer();

        stack.push(Integer.valueOf(scan.next()));
        sb.append("0 ");
        indexStack.push(1);
        for (int i = 2; i <= n; i++) {
            currTower = Integer.valueOf(scan.next());

            while (!stack.isEmpty()) {
                if (stack.peek() > currTower) {
                    sb.append(indexStack.peek() + " ");
                    break;
                }
                stack.pop();
                indexStack.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            }

            stack.push(currTower);
            indexStack.push(i);
        }

        System.out.print(sb.toString());
    }
}