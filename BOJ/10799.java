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
        int curr = 0;
        int totalCount = 0;
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < ca.length; i++) {
            if(ca[i] == '(') {
                if(ca[i+1] == '(') {
                    curr++;
                }
                st.push(ca[i]);
            } else if(ca[i] == ')') {
                if(st.peek() == '(' && ca[i-1] == '(') {
                    st.pop();
                    if(!st.isEmpty()) {
                        totalCount += curr;
                    }
                } else if(st.peek() == '(' && ca[i-1] == ')') {
                    st.pop();
                    curr--;
                    totalCount++;
                }
            }
        }

        System.out.print(totalCount);
    }
}