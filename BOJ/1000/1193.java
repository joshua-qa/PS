package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jgchoi.qa on 2017. 5. 24..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int index = 0;

        while(index < N) {
            N -= index;
            index++;
        }

        if(index % 2 == 1) {
            System.out.println((1 + index - N) + "/" + N);
        } else {
            System.out.println(N + "/" + (1 + index - N));
        }
    }
}