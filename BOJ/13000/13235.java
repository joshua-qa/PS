import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ca = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < ca.length / 2; i++) {
            stack.push(ca[i]);
        }

        for(int i = (ca.length + 1) / 2; i < ca.length; i++) {
            if(stack.peek() != ca[i]) {
                break;
            } else {
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}