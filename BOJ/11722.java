import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int[] P = new int[1001];
    private int[] D = new int[1001];
    private int min;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= input; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= input; i++) {
            D[i] = 1;
            for(int j = 1; j < i; j++) {
                if(P[j] > P[i] && D[i] < D[j] + 1) {
                    D[i] = D[j] + 1;
                }
            }
            min = Math.max(min, D[i]);
        }

        System.out.println(min);
    }
}