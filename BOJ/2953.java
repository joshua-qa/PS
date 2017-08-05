import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[] contest = new int[5];
    int max, result;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for(int i = 0; i < contest.length; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++) {
                contest[i] += Integer.parseInt(st.nextToken());
            }
            if(contest[i] > max) {
                max = contest[i];
                result = i+1;
            }
        }

        System.out.print(result + " " + max);
    }
}