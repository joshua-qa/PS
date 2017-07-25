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
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        System.out.print(solve(n, m));
    }

    private int solve(int n, int m) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return Math.min((m+1)/2, 4);
        }

        if(m > 6) {
            return m-2;
        } else {
            return m > 3 ? 4 : m;
        }
    }
}