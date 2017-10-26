package Joshua.PS;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */
    static long maxPoints(int[] elements) {
        int[] nums = new int[100001];
        long[][] D = new long[100002][2];
        long ans = 0;
        int max = 0;

        for(int i : elements) {
            nums[i]++;
            if(max < i) {
                max = i;
            }
        }

        D[max][0] = D[max-1][1] = (long)max * nums[max];
        D[max-1][0] = (long)(max-1) * nums[max-1];
        ans = Math.max(D[max][0], D[max-1][0]);

        for(int i = max-2; i >= 0; i--) {
            D[i][0] = Math.max(Math.max(D[i+2][0], D[i+3][0]), D[i+1][1]) + (long)nums[i] * i;
            D[i][1] = D[i+1][0];
            ans = Math.max(Math.max(D[i][0], D[i][1]), ans);
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        long res;
        int elements_size = 0;
        elements_size = Integer.parseInt(in.nextLine().trim());

        int[] elements = new int[elements_size];
        for(int i = 0; i < elements_size; i++) {
            int elements_item;
            elements_item = Integer.parseInt(in.nextLine().trim());
            elements[i] = elements_item;
        }

        res = maxPoints(elements);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}