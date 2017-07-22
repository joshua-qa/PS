import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private long[][] D = new long[100][100];
    private int[][] P = new int[100][100];
    private StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                P[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int n = P[0][0];

        D[n][0] = 1;
        D[0][n] = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(D[i][j] == 0 || P[i][j] == 0) {
                    continue;
                } else {
                    n = P[i][j];
                    if(i+n < N) {
                        D[i+n][j] = D[i][j] + D[i+n][j];
                    }
                    if(j+n < N) {
                        D[i][j+n] = D[i][j] + D[i][j+n];
                    }
                }
            }
        }

        System.out.print(D[N-1][N-1]);
    }
}