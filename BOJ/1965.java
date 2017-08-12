import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }
    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[n+1];
        int[] D = new int[n+1];
        for(int i = 1; i <= n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            D[i] = 1;
            for(int j = 1; j < i; j++) {
                if(D[j] + 1 > D[i] && P[j] < P[i]) {
                    D[i] = D[j] + 1;
                }
            }
            if(max < D[i]) {
                max = D[i];
            }
        }

        System.out.print(max);
    }
}