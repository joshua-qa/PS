import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine(), 2);
        long m = Long.parseLong(br.readLine(), 2);

        long a = n * m;
        String x = Long.toBinaryString(a);
        System.out.print(x);
    }
}