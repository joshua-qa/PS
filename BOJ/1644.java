package Joshua.PS.BOJ;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Joshua on 2017-03-14.
 */
public class Main {
    public static int primeCal(ArrayList<Integer> prime, int N) {
        int result = 0;
        int temp = N;
        for (int i = 0; i < prime.size(); i++) {
            for (int j = i; j < prime.size() && temp >= prime.get(j); j++) {
                if(temp >= prime.get(j)) {
                    temp -= prime.get(j);
                }
            }
            if(temp == 0) {
                result++;
                temp = N;
            } else {
                temp = N;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] prime = new int[N+1];
        ArrayList<Integer> primeArray = new ArrayList();

        for (int a = 2; a * a <= N; a++) {
            if(prime[a] == 0) {
                for (int b = a*2; b <= N; b += a) {
                    prime[b] = 1;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if(prime[i] == 0) {
                primeArray.add(i);
            }
        }

        System.out.println(primeCal(primeArray, N));
    }
}