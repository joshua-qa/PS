import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private int n;
    private int[] Dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    private int[] Dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    private StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] board = new int[size][size];
            String[] str = br.readLine().split(" ");
            String[] str1 = br.readLine().split(" ");
            int sx = Integer.parseInt(str[0]);
            int sy = Integer.parseInt(str[1]);
            int ex = Integer.parseInt(str1[0]);
            int ey = Integer.parseInt(str1[1]);
            sb.append(bfs(new Knight(sx, sy, 0), ex, ey, board) + "\n");
        }

        System.out.println(sb);
    }

    private int bfs(Knight start, int endX, int endY, int[][] board) {
        Queue<Knight> visit = new LinkedList<>();
        int boardSize = board.length;
        boolean[][] check = new boolean[boardSize][boardSize];
        visit.add(start);
        check[start.x][start.y] = true;

        while(!visit.isEmpty()) {
            Knight k = visit.remove();

            if(k.x == endX && k.y == endY) {
                return k.move;
            }
            for(int i = 0; i < Dx.length; i++) {
                int currX = k.x + Dx[i];
                int currY = k.y + Dy[i];
                if(currX < 0 || currX >= board.length || currY < 0 || currY >= board.length) {
                    continue;
                }

                if(!check[currX][currY]) {
                    visit.add(new Knight(currX, currY, k.move+1));
                    check[currX][currY] = true;
                }
            }
        }

        return 0;
    }
}

class Knight {
    int x;
    int y;
    int move;
    public Knight(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}