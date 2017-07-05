import java.io.*;

public class Main {
    private static int[] D = new int[1000001];
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());

        D[1] = 0;
        D[2] = 1;

        for(int i = 3; i <= n; i++) {
            if(i % 3 == 0 && i % 2 == 0) {
                D[i] = Math.min(Math.min(D[i/3], D[i/2]), D[i-1]) + 1;
            } else if(i % 2 == 0 && i % 3 != 0) {
                D[i] = Math.min(D[i/2], D[i-1]) + 1;
            } else if (i % 3 == 0 && i % 2 != 0) {
                D[i] = Math.min(D[i/3], D[i-1]) + 1;
            } else {
                D[i] = D[i-1] + 1;
            }
        }

        bw.write(D[n] + "\n");
        bw.flush();
    }
}