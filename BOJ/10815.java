package Joshua.PS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] user;
    static int m, n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        m = Integer.parseInt(br.readLine());
        user = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;

        while (st.hasMoreTokens()) {
            user[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(user);

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            sb.append(Arrays.binarySearch(user, Integer.parseInt(st.nextToken())) >= 0 ? 1 : 0).append(" ");
        }

        System.out.print(sb.toString());
    }
}