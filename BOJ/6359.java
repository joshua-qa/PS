import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            sb.append(solution(Integer.parseInt(br.readLine())) + "\n");
        }

        System.out.print(sb.toString());
    }

    public int solution(int n) {
        int result = 0;
        boolean[] D = new boolean[n+1];

        for(int i = 2; i <= n; i++) {
            for(int j = i; j <= n; j += i) {
                if(!D[j]) {
                    D[j] = true;
                } else {
                    D[j] = false;
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(!D[i]) {
                result++;
            }
        }

        return result;
    }
}