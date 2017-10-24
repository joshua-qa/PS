import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private long[] D = new long[5001];
    private final long MOD = 1000000;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ca = br.readLine().trim().toCharArray();
        int front, curr, total;
        D[0] = 1;
        D[1] = 1;

        for(int i = 2; i <= ca.length; i++) {
            front = ca[i-2] - '0';
            curr = ca[i-1] - '0';
            total = (front * 10) + curr;

            if(front > 2 && curr == 0 || front == 0 && curr == 0) {
                D[ca.length] = 0;
                break;
            } else if(curr > 0 && curr <= 9) {
                D[i] = D[i-1] + D[i];
            }

            if(total >= 10 && total < 27) {
                D[i] = D[i-2] + D[i];
            }
            D[i] %= MOD;
        }

        if(ca.length == 1 && ca[0] - '0' == 0) {
            System.out.println(0);
        } else {
            System.out.println(D[ca.length] % MOD);
        }
    }
}