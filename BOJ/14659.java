import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int n;
    private StringBuilder sb = new StringBuilder();
    private StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] b = new int[n];
        int[] count = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            if(n - i < max) {
                break;
            }
            for(int j = i+1; j < n; j++) {
                if(b[i] > b[j]) {
                    count[i]++;
                } else {
                    break;
                }
            }
            max = Math.max(count[i], max);
        }

        System.out.print(max);
    }
}