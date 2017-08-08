import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n];
        int[] P = new int[n];
        int[] D = new int[n+1];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < i; j++) {
                if(j+T[j] <= i && D[j+T[j]] < D[j] + P[j]) {
                    D[j+T[j]] = D[j] + P[j];
                }
                D[i] = Math.max(D[i], D[j]);
            }
        }

        System.out.print(D[n]);
    }
}