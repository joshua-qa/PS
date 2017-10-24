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
        System.out.print(cal(br.readLine()));
    }

    private int cal(String s) {
        char[] ca = s.toCharArray();
        int total = 0, curr = 0;
        Stack<String> st = new Stack<>();

        for(int i = 0; i < ca.length; i++) {
            if(st.isEmpty() && (ca[i] == ')' || ca[i] == ']')) {
                total = 0;
                break;
            }

            if(ca[i] == '(' || ca[i] == '[') {
                st.push(String.valueOf(ca[i]));
            } else {
                if((ca[i] == ')' && st.peek().equals("(")) || (ca[i] == ']' && st.peek().equals("["))) {
                    String sTemp = st.pop();
                    if(st.isEmpty()) {
                        curr += (sTemp.equals("(")) ? 2 : 3;
                        st.push(String.valueOf(curr));
                    } else {
                        String peek = st.peek();
                        if (isNum(peek)) {
                            curr = Integer.parseInt(peek);
                            curr += (sTemp.equals("(")) ? 2 : 3;
                            st.pop();
                            st.push(String.valueOf(curr));
                        } else {
                            curr += (sTemp.equals("(")) ? 2 : 3;
                            st.push(String.valueOf(curr));
                        }
                    }
                } else if((ca[i] == ')' || ca[i] == ']') && isNum(st.peek())) {
                    curr = Integer.parseInt(st.pop());
                    if(st.isEmpty()) {
                        return 0;
                    }
                    while(!st.isEmpty() && isNum(st.peek())) {
                        curr += Integer.parseInt(st.pop());
                    }
                    curr *= (ca[i] == ')') ? 2 : 3;
                    String temp = st.pop();
                    if( (temp.equals("[") && ca[i] == ')') || (temp.equals("(") && ca[i] == ']') ) {
                        return 0;
                    }
                    st.push(String.valueOf(curr));
                }
            }
            curr = 0;
        }

        int a = st.size();
        for(int i = 0; i < a; i++) {
            if(isNum(st.peek())) {
                total += Integer.parseInt(st.pop());
            } else {
                return 0;
            }
        }

        return total;
    }

    private boolean isNum(String s) {
        if(!s.equals("(") && !s.equals(")") && !s.equals("[") && !s.equals("]")) {
            return true;
        }
        return false;
    }
}