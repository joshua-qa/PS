import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, m, total, ans;
    int[][] app;
    int[][] D = new int[2][10001];
    boolean flag;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        app = new int[n][2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            app[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            app[i][1] = Integer.parseInt(st.nextToken());
            total += app[i][1];
        }

        for(int i = 0; i < n; i++) {
            int curr = app[i][1];
            D[1][curr] = D[0][0] + app[i][0];

            for(int j = curr+1; j <= total; j++) {
                if(D[0][j - curr] != 0) {
                    D[1][j] = D[0][j - curr] + app[i][0];
                }
            }

            for(int j = curr; j <= total; j++) {
                if(D[0][j] < D[1][j]) {
                    D[0][j] = D[1][j];
                }
                D[1][j] = 0;
            }
        }

        for(int i = 0; i <= total; i++) {
            for(int j = 0; j <= 1; j++) {
                if (D[j][i] >= m) {
                    ans = i;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        System.out.print(ans);
    }
}