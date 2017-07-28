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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String[][] bingo = new String[n][m];
        int[] gc = new int[n];
        int[] sc = new int[m];
        int count = 0, max = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                bingo[i][j] = st.nextToken();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!bingo[i][j].contains("9")) {
                    continue;
                } else {
                    for(int k = 0; k < bingo[i][j].length(); k++) {
                        if(bingo[i][j].charAt(k) == '9') {
                            gc[i]++;
                            sc[j]++;
                        }
                    }
                }
                max = Math.max(max, Math.max(gc[i], sc[j]));
            }
            count += gc[i];
        }

        System.out.print(count-max);
    }
}