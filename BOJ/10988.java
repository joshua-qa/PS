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
        Stack<Character> st = new Stack<>();

        int start = ca.length / 2;
        int result = 1;

        for(int i = 0; i < start; i++) {
            st.push(ca[i]);
        }

        if(ca.length % 2 == 1) {
            start++;
        }

        for(int j = start; j < ca.length; j++) {
            if(st.peek() != ca[j]) {
                result = 0;
                break;
            } else {
                st.pop();
            }
        }

        System.out.print(result);
    }
}