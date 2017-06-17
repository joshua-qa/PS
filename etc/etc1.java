package Joshua.PS;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] charArray = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        System.out.println(solution(input));
    }

    public static int solution(String N) {
        int answer = 0;
        int odd = 0;
        int even = 0;
        int odd2 = 0;
        int even2 = 0;
        int doubleovercount = 0;

        char[] test = N.toCharArray();

        for (int i = 0; i < test.length; i++) {
            int temp = test[i] - '0';
            charArray[temp]++;
        }

        for (int i = 0; i < 10; i++) {
            if (charArray[i] % 2 == 1) {
                odd++;
                if(charArray[i] >= 2) {
                    doubleovercount++;
                }
                odd2 += charArray[i] - 1;
            } else {
                even2++;
                if(charArray[i] >= 2) {
                    doubleovercount++;
                }
                even += charArray[i];
            }
        }

        if (doubleovercount == 1 && charArray[0] >= 2) {
            if(odd > 0) {
                answer = 1;
            } else {
                answer = 0;
            }
        } else if (odd >= 1) {
            answer = even + odd2 + 1;
        } else {
            answer = even;
        }

        return answer;
    }
}