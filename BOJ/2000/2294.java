import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int[] P = new int[101];
    private int[] D = new int[10001];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        for(int i = 1; i <= n; i++) {
            P[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= k; i++) {
            D[i] = -1;
        }

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= n; j++) {
                if(i - P[j] >= 0 && D[i - P[j]] != -1) {
                    if (D[i] == -1 || D[i] > D[i - P[j]] + 1) {
                        D[i] = D[i - P[j]] + 1;
                    }
                }
            }
        }

        if(D[k] == -1) {
            System.out.println("-1");
        } else {
            System.out.println(D[k]);
        }
    }
}