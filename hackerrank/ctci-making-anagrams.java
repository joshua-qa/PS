import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by jgchoi.qa on 2017. 8. 24..
 */

public class Solution {

    public static int numberNeeded(String first, String second) {
        int count = 0;
        char[] f = first.toCharArray();
        char[] s = second.toCharArray();

        int[] countOfChar = new int[26];
        for(char c : f) {
            countOfChar[c - 'a']++;
        }

        for(char c : s) {
            if(countOfChar[c - 'a'] == 0) {
                count++;
            } else {
                countOfChar[c - 'a']--;
            }
        }

        for(int i : countOfChar) {
            count += i;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}