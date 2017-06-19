package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computer = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());

        int[][] map = new int[computer][computer];
        for(int i = 0; i < connect; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
            map[y][x] = 1;
        }

        System.out.println(solution(map));

    }

    public static int solution(int[][] board) {
        int answer = 0;
        int curr;
        Queue queue = new LinkedList<Integer>();

        boolean[] visited = new boolean[board.length];
        visited[0] = true;
        queue.add(0);
        while(!queue.isEmpty()) {
            curr = (int)queue.remove();
            for(int i = 0; i < board.length; i++) {
                if(visited[i]) {
                    continue;
                }
                if(board[curr][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    answer++;
                }
            }
        }

        return answer;
    }
}