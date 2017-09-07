import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, m;
    long[] D = new long[70];
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        D[0] = 1;
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        newFibo(69);
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            sb.append(D[m] + "\n");
        }
        System.out.print(sb);
    }

    private long newFibo(int n) {
        if(D[n] != 0) {
            return D[n];
        } else {
            D[n] = newFibo(n - 1) + newFibo(n - 2) + newFibo(n - 3) + newFibo(n - 4);
        }

        return D[n];
    }
}