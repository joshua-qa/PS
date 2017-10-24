import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    char[] A, B;
    int[][] D = new int[1001][1001];
    boolean[] DP = new boolean[1001];
    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        for(int i = 1; i <= A.length; i++) {
            for(int j = 1; j <= B.length; j++) {
                if(A[i-1] == B[j-1]) {
                    D[i][j] = D[i-1][j-1] + 1;
                } else {
                    D[i][j] = Math.max(D[i][j-1], D[i-1][j]);
                }
            }
        }

        rec(A.length, B.length);
        System.out.println(D[A.length][B.length]);
        System.out.print(sb.reverse());
    }

    private void rec(int x, int y) {
        if(x == 0 || y == 0) {
            return;
        }

        if(A[x-1] == B[y-1]) {
            sb.append(B[y-1]);
            rec(x-1, y-1);
        } else if(D[x][y] == D[x][y-1]){
            rec(x, y-1);
        } else if(D[x][y] == D[x-1][y]) {
            rec(x-1, y);
        } else {
            rec(x-1, y-1);
        }
    }
}