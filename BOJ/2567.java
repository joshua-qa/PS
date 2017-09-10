import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[][] paper = new int[120][120];
    int ans, n, x, y;
    int[] Dx = {-1, 0, 0, 1};
    int[] Dy = {0, -1, 1, 0};
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        n = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            fill();
        }

        for(int i = 0; i < paper.length; i++) {
            for(int j = 0; j < paper.length; j++) {
                if(paper[i][j] == 0) {
                    continue;
                }
                for(int k = 0; k < Dx.length; k++) {
                    if(paper[i+Dx[k]][j+Dy[k]] == 0) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private void fill() {
        for(int i = x; i < x+10; i++) {
            for(int j = y; j < y+10; j++) {
                paper[i][j] = 1;
            }
        }
    }
}