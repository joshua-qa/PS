import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long fivecount, twocount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        if(m != 0) {
            fivecount = getFive(n);
            twocount = getTwo(n);

            fivecount -= (getFive(n-m) + getFive(m));
            twocount -= (getTwo(n-m) + getTwo(m));
        }
        System.out.println(Math.min(fivecount, twocount));
    }

    public static long getFive(long n) {
        long five = 0;
        for(long i = 5; n/i >= 1; i *= 5) {
            five += n/i;
        }
        return five;
    }

    public static long getTwo(long n) {
        long two = 0;
        for(long i = 2; n/i >= 1; i *= 2) {
            two += n/i;
        }
        return two;
    }
}