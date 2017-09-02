import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by jgchoi.qa on 2017. 9. 1..
 * 다시 풀어볼 필요 있음. xor로 하는 문제임.
 */

public class Solution {

    public static int lonelyInteger(int[] a) {
        ArrayList<Integer> lonely = new ArrayList<>();
        for(int i : a) {
            if (lonely.contains(i)) {
                lonely.remove(lonely.indexOf(i));
            } else {
                lonely.add(i);
            }
        }

        return lonely.get(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }
}
