import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0, i = 1;

        while(N > 0) {
            if(i > N) {
                i = 1;
            }

            N -= i++;
            result++;
        }

        System.out.print(result);
    }
}