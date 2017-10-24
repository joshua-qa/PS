import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ca = br.readLine().toCharArray();

        char[] joi = "JOI".toCharArray();
        char[] ioi = "IOI".toCharArray();
        int[] pjoi = {0, 0, 0};
        int[] pioi = {0, 0, 1};
        int joiCount = 0;
        int ioiCount = 0;

        int m = joi.length;
        int j = 0;
        for(int i = 0; i < ca.length; i++) {
            while(j > 0 && ca[i] != joi[j]) {
                j = pjoi[j-1];
            }
            if(ca[i] == joi[j]) {
                if(j == m-1) {
                    joiCount++;
                    j = 0;
                } else {
                    j++;
                }
            }
        }

        j = 0;
        for(int i = 0; i < ca.length; i++) {
            while(j > 0 && ca[i] != ioi[j]) {
                j = pioi[j-1];
            }
            if(ca[i] == ioi[j]) {
                if(j == m-1) {
                    ioiCount++;
                    j = 0;
                    i--;
                } else {
                    j++;
                }
            }
        }
        System.out.print(joiCount + "\n" + ioiCount);
    }
}