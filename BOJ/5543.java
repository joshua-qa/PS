import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] b = new int[3];
        int[] d = new int[2];

        for(int i = 0; i < 3; i++) {
            b[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < 2; i++) {
            d[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(b, d));
    }

    private int solution(int[] b, int[] d) {
        int result = 9999;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 2; j++) {
                if((b[i] + d[j] - 50) < result) {
                    result = b[i] + d[j] - 50;
                }
            }
        }

        return result;
    }
}