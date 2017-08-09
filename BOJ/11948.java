import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    int[] scoreGroup1 = new int[4];
    int[] scoreGroup2 = new int[2];
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 6; i++) {
            if(i > 3) {
                scoreGroup2[i-4] = Integer.parseInt(br.readLine());
            } else {
                scoreGroup1[i] = Integer.parseInt(br.readLine());
            }
        }

        Arrays.sort(scoreGroup1);
        int ans = Math.max(scoreGroup2[0], scoreGroup2[1]);

        for(int i = 3; i > 0; i--) {
            ans += scoreGroup1[i];
        }
        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }
}