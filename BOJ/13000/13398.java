import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[] DL = new int[100002];
    int[] DR = new int[100002];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] P = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = P[1];
        DL[1] = P[1];
        DR[n] = P[n];

        for(int i = 2; i <= n; i++) {
            DL[i] = Math.max(DL[i-1] + P[i], P[i]);
        }

        for(int i = n-1; i >= 1; i--) {
            DR[i] = Math.max(DR[i+1] + P[i], P[i]);
        }

        for(int i = 2; i <= n; i++) {
            max = Math.max(max, DL[i]);
        }

        for (int i = 2; i < n; i++) {
            max = Math.max(max, DL[i-1] + DR[i+1]);
        }

        System.out.println(max);
    }
}