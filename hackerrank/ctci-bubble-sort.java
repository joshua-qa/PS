import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by jgchoi.qa on 2017. 8. 24..
 */

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        sort(a, n);
    }

    private static void sort(int[] a, int n) {
        StringBuilder sb = new StringBuilder();
        int totalSwaps = 0, temp = 0;
        for (int i = 0; i < n; i++) {
            int numberOfSwaps = 0;
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] ^= a[j + 1];
                    a[j + 1] ^= a[j];
                    a[j] ^= a[j + 1];
                    totalSwaps++;
                    numberOfSwaps++;
                }
            }

            if (numberOfSwaps == 0) {
                sb.append("Array is sorted in " + totalSwaps + " swaps.\n");
                sb.append("First Element: " + a[0] + "\n");
                sb.append("Last Element: " + a[n-1]);
                break;
            }
        }

        System.out.print(sb);
    }
}
