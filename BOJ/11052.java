import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] P;
    static int[] D;
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        P = new int[n+1];
        D = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        D[1] = P[1];

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= i; j++) {
                D[i] = Math.max(D[i], D[j] + P[i-j]);
            }
        }

        System.out.println(D[n]);
    }
}