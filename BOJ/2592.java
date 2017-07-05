import java.io.*;
import java.util.Arrays;

public class Main {
    private static int[] D = new int[10];
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < D.length; i++) {
            D[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(D);
        int ave = D[0], fre = 0, curr = 1, frenum = 0;

        for(int i = 1; i < D.length; i++) {
            ave += D[i];
            if(curr == 0 || D[i] == D[i-1]) {
                curr++;
            } else if(D[i] != D[i-1]) {
                if(fre < curr) {
                    fre = curr;
                    frenum = D[i-1];
                }
                curr = 0;
            }
        }
        if(fre < curr) {
            fre = curr;
            frenum = D[9];
        }

        bw.write((ave / 10) + "\n" + frenum + "\n");
        bw.flush();
    }
}