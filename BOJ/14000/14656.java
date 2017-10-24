import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long start = System.currentTimeMillis();
        int n = Integer.parseInt(br.readLine());
        int[] student = new int[n+1];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            student[i] = Integer.parseInt(st.nextToken());
            if(student[i] != i) {
                result++;
            }
        }

        System.out.print(result);
    }
}