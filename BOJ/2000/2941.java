package Joshua.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jgchoi.qa on 2017. 5. 22..
 */
public class Main {
    static String[] croatianArray = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
    static String dzEqual = "dz=";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        int count = 0;

        while(sb.length() > 0) {
            if(sb.length() >= 3 && sb.substring(0,3).equals(dzEqual)) {
                count++;
                sb.delete(0,3);
            } else if(sb.length() >= 2 && compare(sb.substring(0,2))) {
                count++;
                sb.delete(0,2);
            } else {
                count++;
                sb.delete(0,1);
            }
        }

        System.out.println(count);
    }

    private static boolean compare(String input) {
        for(int i = 0; i < croatianArray.length; i++) {
            if (croatianArray[i].equals(input)) {
                return true;
            }
        }
        return false;
    }
}
