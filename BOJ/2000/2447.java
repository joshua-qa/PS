import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int n;
    char[][] square;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        square = new char[n][n];
        rec(n, 0, 0);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(square[i][j] == 0) {
                    sb.append(" ");
                } else {
                    sb.append(square[i][j]);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private void rec(int n, int x, int y) {
        if(n == 1) {
            square[x][y] = '*';
            return;
        }
        if(n == 3) {
            square[x][y] = '*';
            square[x][y + 1] = '*';
            square[x][y + 2] = '*';
            square[x + 1][y] = '*';
            square[x + 1][y + 1] = 32;
            square[x + 1][y + 2] = '*';
            square[x + 2][y] = '*';
            square[x + 2][y + 1] = '*';
            square[x + 2][y + 2] = '*';
            return;
        } else {
            rec(n/3, x, y);
            rec(n/3, x + n/3, y);
            rec(n/3, x + n/3 + n/3, y);
            rec(n/3, x + n/3 + n/3, y + n/3);
            rec(n/3, x, y + n/3);
            rec(n/3, x, y + n/3 + n/3);
            rec(n/3, x + n/3, y + n/3 + n/3);
            rec(n/3, x + n/3 + n/3, y + n/3 + n/3);
        }
    }
}