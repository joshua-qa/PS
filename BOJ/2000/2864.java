import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();
        int A5 = 0, A6 = 0, B5 = 0, B6 = 0;
        
        for(int i = 0; i < A.length; i++) {
            int t = A[i] - '0';
            if(t == 5 || t == 6) {
                A5 = (A5 * 10) + 5;
                A6 = (A6 * 10) + 6;
            } else {
                A5 = (A5 * 10) + t;
                A6 = (A6 * 10) + t;
            }
        }
        for(int i = 0; i < B.length; i++) {
            int t = B[i] - '0';
            if(t == 5 || t == 6) {
                B5 = (B5 * 10) + 5;
                B6 = (B6 * 10) + 6;
            } else {
                B5 = (B5 * 10) + t;
                B6 = (B6 * 10) + t;
            }
        }
        
        System.out.print((A5+B5) + " " + (A6+B6));
    }
}