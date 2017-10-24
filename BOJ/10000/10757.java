import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] str = br.readLine().trim().split(" ");
        BigInteger a = new BigInteger(str[0]);
        BigInteger b = new BigInteger(str[1]);

        a = a.add(b);

        System.out.print(a.toString());
    }
}