import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    Queue<Pair> visit = new LinkedList<>();
    private int[][] dist;
    private int input;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        input = Integer.parseInt(br.readLine());

        dist = new int[input+1][input+1];

        for(int i = 0; i <= input; i++) {
            Arrays.fill(dist[i], -1);
        }

        bfs(1);

        for(int i = 0; i <= input; i++) {
            if(dist[input][i] != -1 && dist[input][i] < min) {
                min = dist[input][i];
            }
        }

        System.out.println(min);
    }

    private void bfs(int start) {
        visit.add(new Pair(start, 0));
        dist[start][0] = 0;

        while(!visit.isEmpty()) {
            Pair p = visit.remove();
            int s = p.s;
            int c = p.c;

            if(dist[s][s] == -1) {
                dist[s][s] = dist[s][c] + 1;
                visit.add(new Pair(s, s));
            }

            if(s-1 > 0) {
                if (dist[s - 1][c] == -1) {
                    dist[s - 1][c] = dist[s][c] + 1;
                    visit.add(new Pair(s - 1, c));
                }
            }

            if(s+c <= input) {
                if (dist[s + c][c] == -1) {
                    dist[s + c][c] = dist[s][c] + 1;
                    visit.add(new Pair(s + c, c));
                }
            }
        }
    }
}

class Pair {
    int s;
    int c;

    public Pair(int s, int c) {
        this.s = s;
        this.c = c;
    }
}