import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final int MAX = 1000000007;
    int n, currX, currY;
    char[][] map;
    int[][] D;
    Deque<Room> visit = new ArrayDeque<>();
    int[] Dx = {-1, 0, 0, 1};
    int[] Dy = {0, -1, 1, 0};
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        D = new int[n][n];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(D[i], MAX);
        }

        D[0][0] = 0;
        bfs(0, 0);

        System.out.print(D[n-1][n-1]);
    }

    private void bfs(int x, int y) {
        visit.addFirst(new Room(x, y));

        while(!visit.isEmpty()) {
            Room currentRoom = visit.pollFirst();

            for(int i = 0; i < Dx.length; i++) {
                currX = currentRoom.x + Dx[i];
                currY = currentRoom.y + Dy[i];

                if(currX < 0 || currX >= n || currY < 0 || currY >= n) {
                    continue;
                }

                if(D[currX][currY] == MAX) {
                    if(map[currX][currY] == '1') {
                        D[currX][currY] = D[currentRoom.x][currentRoom.y];
                        visit.addFirst(new Room(currX, currY));
                    } else {
                        D[currX][currY] = D[currentRoom.x][currentRoom.y] + 1;
                        visit.addLast(new Room(currX, currY));
                    }
                }
            }
        }
    }
}

class Room {
    int x;
    int y;
    public Room(int x, int y) {
        this.x = x;
        this.y = y;
    }
}