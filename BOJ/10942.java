import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int[] numList = new int[2001];
    private int[][] D = new int[2001][2001];
    private int s, e;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            D[i][i] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = i+1; j <= n; j++) {
                D[i][j] = (numList[i] == numList[j]) ? 1 : 0;
            }
        }

        for(int a = 0; a < m; a++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            sb.append((DP(s, e) ? 1 : 0) + "\n");
        }

        System.out.print(sb);
    }

    private boolean DP(int s, int e) {
        int center = (s+e) / 2;

        for(int i = s, j = e; i <= center; i++, j--) {
            if(D[i][j] == 0) {
                return false;
            }
        }
        return true;
    }
}