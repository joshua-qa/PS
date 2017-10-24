import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    int n, ans, curr;
    int[] rope;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        rope = new int[n];
        for(int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        for(int i = 0; i < n; i++) {
            curr = rope[i] * (n - i);
            if(ans < curr) {
                ans = curr;
            }
        }

        System.out.print(ans);
    }
}