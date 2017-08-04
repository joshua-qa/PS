import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ca = br.readLine().toCharArray();
        for(char c : ca) {
            if(c == '(') {
                stack.push(1);
            } else {
                stack.push(-1);
            }
        }

        int prev = 0;
        int result = 0;
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            if(prev == 0) {
                result += 10;
                prev = (temp == 1) ? 1 : -1;
            } else if(prev == 1) {
                result += (temp == 1) ? 5 : 10;
                prev = (temp == 1) ? 1 : -1;
            } else if(prev == -1) {
                result += (temp == -1) ? 5 : 10;
                prev = (temp == -1) ? -1 : 1;
            }
        }

        System.out.print(result);
    }
}