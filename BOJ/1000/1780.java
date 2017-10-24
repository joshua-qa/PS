import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private StringTokenizer st;
    private int[] count = new int[3];
    private int[] result = new int[3];
    private static final int CUT = 9;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken()) + 1;
                count[paper[i][j]]++;
            }
        }

        if(count[0] == n*n) {
            result[0] = 1;
        } else if(count[1] == n*n) {
            result[1] = 1;
        } else if(count[2] == n*n) {
            result[2] = 1;
        } else {
            int slice = n / 3;
            for(int i = 0; i < CUT; i++) {
                rec(paper, (i / 3) * slice, (i % 3) * slice, slice);
            }
        }
        System.out.print(result[0] + "\n" + result[1] + "\n" + result[2]);
    }

    private void rec(int[][] paper, int x, int y, int n) {
        int isFill = judge(paper, x, y, n);
        if(isFill != -1) {
            result[isFill]++;
            return;
        } else {
            int slice = n / 3;
            for(int i = 0; i < CUT; i++) {
                rec(paper, (i / 3) * slice + x, (i % 3) * slice + y, slice);
            }
        }
    }

    private int judge(int[][] paper, int x, int y, int n) {
        int[] c = new int[3];
        for(int i = x; i < x+n; i++) {
            for(int j = y; j < y+n; j++) {
                c[paper[i][j]]++;
            }
        }

        if(c[0] == n*n) {
            return 0;
        } else if(c[1] == n*n) {
            return 1;
        } else if(c[2] == n*n) {
            return 2;
        } else {
            return -1;
        }
    }
}