import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ca = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        if(ca.length == 1 && ca[0] - '0' == 0) {
            System.out.print("0");
        } else {
            for (int i = 0; i < ca.length; i++) {
                sb.append(convert(ca[i] - '0'));
            }

            if(sb.substring(0,1).equals("0")) {
                sb.delete(0,1);
            }
            if(sb.substring(0,1).equals("0")) {
                sb.delete(0,1);
            }
            System.out.print(sb.toString());
        }
    }

    private static String convert(int n) {
        StringBuilder str = new StringBuilder();
        int t = n;

        while(t != 0) {
            str.append(t % 2);
            t /= 2;
        }
        if(str.length() == 0) {
            str.append(0);
            str.append(0);
            str.append(0);
        } else if(str.length() == 1) {
            str.append(0);
            str.append(0);
        } else if(str.length() == 2) {
            str.append(0);
        }

        str.reverse();

        return str.toString();
    }
}