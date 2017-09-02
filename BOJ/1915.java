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
        
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
    
        char[][] board = new char[x][y];
        for(int i = 0; i < x; i++) {
            board[i] = br.readLine().toCharArray();
        }

        System.out.print(solution(board));
    }

    public int solution(char[][] board)
    {
        int answer = 0;
        int[][] D = new int[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '0') {
                    continue;
                } else if(i-1 < 0 || j-1 < 0) {
                    D[i][j] = 1;
                    if(answer == 0) {
                        answer = 1;
                    }
                    continue;
                }

                if(D[i-1][j-1] == D[i-1][j] && D[i-1][j-1] == D[i][j-1]) {
                    D[i][j] = D[i-1][j-1] + 1;
                } else {
                    D[i][j] = Math.min(Math.min(D[i-1][j-1], D[i][j-1]), D[i-1][j]) + 1;
                }
                answer = Math.max(D[i][j], answer);
            }
        }

        return answer * answer;
    }
}