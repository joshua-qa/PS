import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    int n;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        if(n <= 20) {
            hanoi(1, 2, 3, n);
            int ans = (1 << n) - 1;
            System.out.print(ans + "\n" + sb);
        } else {
            BigInteger bigAns = BigInteger.ONE;
            for(int i = 0; i < n; i++) {
                bigAns = bigAns.multiply(BigInteger.valueOf(2));
            }
            bigAns = bigAns.subtract(BigInteger.ONE);
            System.out.print(bigAns.toString());
        }
    }

    private void hanoi(int start, int temp, int target, int count) {
        if(count == 1) {
            if(n <= 20) {
                sb.append(start + " " + target + "\n");
            }
            return;
        } else {
            hanoi(start, target, temp, count-1);
            if(n <= 20) {
                sb.append(start + " " + target + "\n");
            }
            hanoi(temp, start, target, count-1);
        }
    }
}