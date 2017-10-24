import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jgchoi.qa on 2017. 5. 5..
 */
public class Main {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int pushNum;

        for(int i = 0; i < num; i++) {
            String input = scan.next();

            if(input.equals("push")) {
                pushNum = scan.nextInt();
                push(pushNum);
            } else if(input.equals("pop")) {
                pop();
            } else if(input.equals("size")) {
                size();
            } else if(input.equals("empty")) {
                empty();
            } else if(input.equals("top")) {
                top();
            }
        }

        System.out.println(sb);
    }

    public static void push(int N) {
        stack.push(N);
    }
    
    public static void pop() {
        if(stack.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(stack.pop()+"\n");
        }
    }

    public static void size() {
        sb.append(stack.size()+"\n");
    }

    public static void empty() {
        sb.append(stack.isEmpty() ? "1\n" : "0\n");
    }

    public static void top() {
        if(stack.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(stack.peek()+"\n");
        }
    }
}
