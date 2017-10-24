package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jgchoi.qa on 2017. 5. 26..
 */
public class Main {
    static int[] primeArray = new int[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int num, count;
        prime();

        while(true) {
            num = Integer.parseInt(br.readLine());
            count = 0;

            if(num == 0) {
                break;
            }

            for(int i = num + 1; i <= num * 2; i += 2) {
                if(i != 2 && i % 2 == 0) {
                    i++;
                }

                if(primeArray[i] == 0) {
                    count++;
                }
            }
            sb.append(count + "\n");
        }

        System.out.println(sb.toString());
    }

    private static void prime() {
        for(int i = 2; i*i < primeArray.length; i++) {
            if(primeArray[i] == 1) {
                continue;
            } else {
                for (int j = i * 2; j < primeArray.length; j += i) {
                    primeArray[j] = 1;
                }
            }
        }
    }
}