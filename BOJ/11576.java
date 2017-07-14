import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] aNumber = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            aNumber[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> result = convert(a, b, aNumber);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> convert(int a, int b, int[] aNumber) {
        ArrayList<Integer> bNumber = new ArrayList<>();
        int aDecimal = 0;
        int curr = 0;
        int bPow = b;

        for(int i = aNumber.length - 1, pow = 1; i >= 0; i--, pow *= a) {
            aDecimal += aNumber[i] * pow;
        }

        curr = aDecimal % bPow;
        aDecimal -= curr;
        bNumber.add(curr);
        bPow *= b;
        while(aDecimal != 0) {
            curr = aDecimal % bPow;
            aDecimal -= curr;
            bNumber.add(curr / (bPow / b));

            bPow *= b;
        }

        Collections.reverse(bNumber);
        return bNumber;
    }
}