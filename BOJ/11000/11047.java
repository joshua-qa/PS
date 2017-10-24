import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int curr = 0;
        int result = 0;

        int[] coin = new int[N];
        for(int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            if(coin[i] <= M) {
                curr = i;
            }
        }

        while(M > 0) {
            result += M / coin[curr];
            M %= coin[curr];
            curr--;
        }

        System.out.print(result);
    }
}