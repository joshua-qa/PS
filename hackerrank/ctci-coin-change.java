import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long makeChange(int[] coins, int money) {
        long[] DP = new long[money+1];

        DP[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= money; j++) {
                if(j - coins[i] >= 0) {
                    DP[j] += DP[j - coins[i]];
                }
            }
        }

        return DP[money];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}