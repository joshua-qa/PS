import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int x, y;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if(x == 0 && y == 0) {
                break;
            }

            int[][] board = new int[x][y];
            for(int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < y; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(solution(board) + "\n");
        }

        System.out.print(sb);
    }

    public int solution(int [][]board)
    {
        int answer = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0) {
                    continue;
                } else if(i-1 < 0 || j-1 < 0) {
                    if(answer == 0) {
                        answer = 1;
                    }
                    continue;
                }

                if(board[i-1][j-1] == board[i-1][j] && board[i-1][j-1] == board[i][j-1]) {
                    board[i][j] = board[i-1][j-1] + 1;
                } else {
                    board[i][j] = Math.min(Math.min(board[i-1][j-1], board[i][j-1]), board[i-1][j]) + 1;
                }
                answer = Math.max(board[i][j], answer);
            }
        }

        return answer;
    }
}