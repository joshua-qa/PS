package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jgchoi.qa on 2017. 5. 25..
 */
public class Main {
    static int[] primeArray = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int[] numArray = new int[num];
        prime();

        for(int a = 0; a < num; a++) {
            numArray[a] = Integer.parseInt(br.readLine());

            int temp;


            if (numArray[a] % 4 == 0 && numArray[a] != 4) {
                temp = (numArray[a] / 2) - 1;
            } else {
                temp = numArray[a] / 2;
            }

            for (int i = temp; i > 0; i -= 2) {
                if (primeArray[i] != 0) {
                    continue;
                } else if (primeArray[i] == 0 && primeArray[numArray[a] - i] == 0) {
                    sb.append(i + " " + (numArray[a] - i) + "\n");
                    break;
                }
            }
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