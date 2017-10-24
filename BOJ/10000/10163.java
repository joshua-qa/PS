import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, x, y, w, h;
    int[] P;
    int[][] map = new int[101][101];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        P = new int[n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            check(i);
        }

        for(int i = 1; i < P.length; i++) {
            sb.append(P[i] + "\n");
        }

        System.out.print(sb);
    }

    private void check(int n) {
        for(int i = x; i < x + w; i++) {
            for(int j = y; j < y + h; j++) {
                if(map[i][j] != 0) {
                    P[map[i][j]]--;
                }
                map[i][j] = n;
                P[n]++;
            }
        }
    }
}