import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    int[][] sudoku = new int[9][9];
    final int N = 9;
    boolean flag = false;
    Vector<String> vc = new Vector<>();

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if(sudoku[i][j] == 0) {
                    vc.add(i + " " + j);
                }
            }
        }

        solve(0);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private void solve(int index) {
        if(index == vc.size()) {
            flag = true;
            return;
        }
        int x = Integer.parseInt(vc.get(index).split(" ")[0]);
        int y = Integer.parseInt(vc.get(index).split(" ")[1]);

        for(int i = 1; i <= 9; i++) {
            if(judge(x, y, i)) {
                sudoku[x][y] = i;
                solve(index+1);
            }
            if(!flag) {
                sudoku[x][y] = 0;
            }
        }
    }

    private boolean judge(int x, int y, int n) {
        int squareBorderX = x - (x % 3);
        int squareBorderY = y - (y % 3);

        for(int i = 0; i < N; i++) {
            if(sudoku[x][i] == n || sudoku[i][y] == n) {
                return false;
            }
        }

        for(int i = squareBorderX; i < squareBorderX + 3; i++) {
            for(int j = squareBorderY; j < squareBorderY + 3; j++) {
                if(sudoku[i][j] == n) {
                    return false;
                }
            }
        }

        return true;
    }
}