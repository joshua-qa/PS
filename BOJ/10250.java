package Joshua.PS.BOJ;

import java.util.*;

/**
 * Created by jgchoi.qa on 2017. 5. 17..
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Num = scan.nextInt();
        StringBuilder sb = new StringBuilder();

        int[] H = new int[Num];
        int[] W = new int[Num];
        int[] N = new int[Num];

        for (int i = 0; i < Num; i++) {
            H[i] = scan.nextInt();
            W[i] = scan.nextInt();
            N[i] = scan.nextInt();
        }

        for (int i = 0; i < Num; i++) {
            if (N[i] % H[i] > 0) {
                int temp = (N[i] / H[i]) + 1;
                int temp2 = (N[i] % H[i]);
                sb.append(temp2);
                if (temp < 10) {
                    sb.append("0" + temp);
                } else {
                    sb.append(temp);
                }
            } else if (N[i] % H[i] == 0) {
                int temp = (N[i] / H[i]);
                int temp2 = N[i];

                sb.append(temp2);
                if (temp < 10) {
                    sb.append("0" + temp);
                } else {
                    sb.append(temp);
                }
            }
            System.out.println(sb);
            sb.delete(0, sb.length());
        }
    }
}