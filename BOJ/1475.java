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
        StringBuffer sb = new StringBuffer(br.readLine());
        int[] numArray = new int[10];
        int result = 0;

        for(int i = 0; i < sb.length(); i++) {
            int temp = sb.charAt(i) - '0';
            numArray[temp]++;
        }

        result = (numArray[6] + numArray[9] + 1) / 2;

        for(int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                continue;
            } else {
                if (numArray[i] > result) {
                    result = numArray[i];
                }
            }
        }

        System.out.println(result);
    }
}