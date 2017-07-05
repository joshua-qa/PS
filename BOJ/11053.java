import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static int[] D = new int[1001];
    private static int[] A = new int[1001];
    private static int max = 0;
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            A[i] = Integer.valueOf(st.nextToken());
        }

        D[1] = 1;

        for(int i = 1; i <= n; i++) {
            D[i] = 1;
            for(int j = 1; j <= i; j++) {
                if(A[i] > A[j] && D[i] < D[j]+1) {
                    D[i] = D[j] + 1;
                }
            }
            if(D[i] > max) {
                max = D[i];
            }
        }

        System.out.println(max);
    }
}