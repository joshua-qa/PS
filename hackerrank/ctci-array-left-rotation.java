import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by jgchoi.qa on 2017. 8. 24..
 */

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            if(i - k < 0) {
                result[i - k + n] = a[i];
            } else {
                result[i - k] = a[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = arrayLeftRotation(a, n, k);
        StringBuilder sb = new StringBuilder();
        for(int i : output) {
            sb.append(i + " ");
        }

        System.out.print(sb);
    }
}
