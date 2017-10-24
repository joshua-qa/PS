import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] score = new int[n][3];
        int temp = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < score[0].length; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i < n; i++) {
            temp = 0;
            for(int j = 0; j < score[0].length; j++) {
                if(judge(score[i][j], score, i, j)) {
                    temp += score[i][j];
                }
            }
            System.out.println(temp);
        }
    }

    private boolean judge(int n, int[][] score, int x, int y) {
        for(int i = 0; i < score.length; i++) {
            if(i == x) {
                continue;
            }
            if(n == score[i][y]) {
                return false;
            }
        }

        return true;
    }
}