import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int[] D = new int[31];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        D[2] = 3;
        D[4] = 11;
        D[6] = 41;

        for(int i = 8; i <= n; i += 2) {
            D[i] = D[i-4] * 2 + D[i-2] * 3 + (D[i-4] - D[i-6]);
        }

        System.out.println(D[n]);
    }
}