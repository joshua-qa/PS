import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int maxStart, maxLength, currStart, currLength;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        while(true) {
            String s = br.readLine();
            if(s.contains("E-N-D")) {
                break;
            } else {
                sb.append(s);
            }
        }

        char[] input = sb.toString().toCharArray();
        sb.delete(0, sb.length());

        for(int i = 0; i < input.length; i++) {
            char c = input[i];
            if((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 45) {
                currLength++;
                if(currStart == -1) {
                    currStart = i;
                }
            } else {
                if(maxLength < currLength) {
                    maxLength = currLength;
                    maxStart = currStart;
                }
                currLength = 0;
                currStart = -1;
            }
        }

        for(int i = maxStart; i < maxStart+maxLength; i++) {
            sb.append(input[i]);
        }

        System.out.print(sb.toString().toLowerCase());
    }
}