import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Joshua on 2017-06-13.
 */
public class Main {
    static int[] n = new int[7];
    static int min, total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 7; i++) {
            n[i] = Integer.parseInt(br.readLine());
            if(n[i] % 2 == 1) {
                total += n[i];

                if(min == 0 || min > n[i]) {
                    min = n[i];
                }
            }
        }

        if(total == 0) {
            System.out.println("-1");
        } else {
            System.out.print(total + "\n" + min);
        }
    }
}
