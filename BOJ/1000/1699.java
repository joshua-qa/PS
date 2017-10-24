import java.io.*;

public class Main {
    private static int[] D;
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        D = new int[n+1];

        D[1] = 1;
        D[2] = 2;

        for(int i = 3; i <= n; i++) {
            D[i] = D[i-1] + 1;
            for(int j = 2; j * j <= i; j++) {
                if(j*j == i) {
                    D[i] = 1;
                    break;
                } else {
                    if(D[i] > D[i-(j*j)]) {
                        D[i] = D[i - (j * j)] + 1;
                    }
                }
            }
        }

        bw.write(D[n] + "\n");
        bw.flush();
    }
}