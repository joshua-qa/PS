import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        if(a != 0 && b != 0) {
            char[][] map = new char[a][b];

            for (int i = 0; i < a; i++) {
                map[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < a; i++) {
                for (int j = b - 1; j >= 0; j--) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }

        }
        System.out.print(sb);
    }
}