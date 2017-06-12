package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Joshua on 2017-06-12.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.parseInt(br.readLine());
        int max = Integer.parseInt(br.readLine());

        int total = 0, minSqrt = 0, maxSqrt = 0;
        boolean flag = false;

        minSqrt = (int) Math.sqrt(min);
        maxSqrt = (int) Math.sqrt(max);



        for(int i = minSqrt; i <= maxSqrt; i++) {
            if(i * i < min) {
                flag = true;
                continue;
            }
            total += i*i;
        }
        if(flag) {
            minSqrt += 1;
        }

        if(total > 0) {
            System.out.println(total);
            System.out.print((minSqrt) * (minSqrt));
        } else {
            System.out.println("-1");
        }
    }
}
