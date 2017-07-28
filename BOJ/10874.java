import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int curr = 0;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] score = new int[n][10];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            curr = 0;
            for(int j = 0; j < score[0].length; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
                if((j % 5) + 1 == score[i][j]) {
                    curr++;
                }
            }
            if(curr == 10) {
                sb.append((i+1) + "\n");
            }
        }
        System.out.print(sb);
    }
}