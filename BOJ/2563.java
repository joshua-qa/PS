import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private boolean[][] paper = new boolean[102][102];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine().trim());
        int result = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = x; j < x+10; j++) {
                for(int k = y; k < y+10; k++) {
                    if(paper[j][k]) {
                        continue;
                    } else {
                        paper[j][k] = true;
                        result++;
                    }
                }
            }
        }

        System.out.print(result);
    }
}