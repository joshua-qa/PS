package Joshua.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jgchoi.qa on 2017. 5. 22..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        int num = Integer.parseInt(br.readLine());
        int[] K = new int[num];
        int[] N = new int[num];

        for (int i = 0; i < num; i++) {
            K[i] = Integer.parseInt(br.readLine());
            N[i] = Integer.parseInt(br.readLine());
            sb.append(call(K[i], N[i]) + "\n");
        }

        System.out.print(sb.toString());
    }

    private static int call(int k, int n) {
        if(k == 0) {
            return n;
        } else if(n == 1) {
            return 1;
        } else {
            return call(k-1, n) + call(k, n-1);
        }
    }
}
