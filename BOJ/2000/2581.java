package Joshua.PS;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jgchoi.qa on 2017. 4. 8..
 */
public class Main {
    static int[] primeArray = new int[10001];
    static List<Integer> mnList = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt();

        prime();
        cal(M, N);
    }

    private static void cal(int m, int n) {
        int result = 0;
        for (int a = m; a <= n; a++) {
            if (primeArray[a] == 0) {
                mnList.add(a);
                result += a;
            }
        }

        if (result == 0) {
            System.out.println("-1");
        } else {
            System.out.println(result);
            System.out.println(mnList.get(0));
        }
    }

    private static void prime() {
        primeArray[0] = primeArray[1] = 1;

        for (int i = 2; i*i < primeArray.length; i++) {
            for (int j = i*2; j < primeArray.length; j += i) {
                if (primeArray[j] == 1) {
                    continue;
                } else {
                    primeArray[j] = 1;
                }
            }
        }
    }
}