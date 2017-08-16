import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int[] n = new int[10001];
    int a, b;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(br.readLine());
        for(int i = 0; i < a; i++) {
            b = Integer.parseInt(br.readLine());
            n[b]++;
        }

        for(int i = 0; i < 10001; i++) {
            for(int j = 0; j < n[i]; j++) {
                sb.append(i + "\n");
            }
        }
        System.out.print(sb);
    }
}