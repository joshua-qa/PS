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
        int C = Integer.parseInt(br.readLine());

        int h = C / 60;
        int m = C % 60;

        N += h;
        M += m;

        if(M > 59) {
            N += M / 60;
            M %= 60;
        }

        if(N > 23) {
            N %= 24;
        }

        System.out.print(N + " " + M);
    }
}