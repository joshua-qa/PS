import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private char[][] map = new char[400][400];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int count = (input*4) - 3;
        rec(input, 0, count);

        for(int i = 0; i < count; i++) {
            for(int j = 0; j < count; j++) {
                if(map[i][j] == 0) {
                    sb.append(" ");
                } else {
                    sb.append(map[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private void rec(int n, int start, int count) {
        if(n == 0) {
            return;
        }
        for(int i = start; i < start+count; i++) {
            map[start][i] = 42;
            map[i][start] = 42;
            map[start+count-1][i] = 42;
            map[i][start+count-1] = 42;
        }

        rec(n-1, start+2, count-4);
    }
}