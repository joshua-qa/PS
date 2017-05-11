package Joshua.PS.BOJ;

import java.util.*;

/**
 * Created by jgchoi.qa on 2017. 5. 11..
 */
public class Main {;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append(scan.next());
        int N = scan.nextInt();
        int cursor = sb.length();

        for(int i = 0; i < N; i++) {
            String input = scan.next();
            if(input.equals("L")) {
                if(cursor == 0) {
                    continue;
                } else {
                    cursor--;
                }
            } else if(input.equals("D")) {
                if(cursor == sb.length()) {
                    continue;
                } else {
                    cursor++;
                }
            } else if(input.equals("B")) {
                if(cursor == 0) {
                    continue;
                } else {
                    sb.delete(cursor - 1, cursor);
                    cursor--;
                }
            } else if(input.equals("P")) {
                String temp = scan.next();
                sb.insert(cursor, temp);
                cursor++;
            }
        }

        System.out.println(sb);
    }
}