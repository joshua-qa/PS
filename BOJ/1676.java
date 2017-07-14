import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        if(n != 0) {
            count = Math.min(getTwo(n), getFive(n));
        }
        System.out.print(count);
    }

    public static int getFive(int n) {
        int five = 0;
        for(int i = 5; n/i >= 1; i *= 5) {
            five += n/i;
        }
        return five;
    }

    public static int getTwo(int n) {
        int two = 0;
        for(int i = 2; n/i >= 1; i *= 2) {
            two += n/i;
        }
        return two;
    }
}