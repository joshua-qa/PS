import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2017.07.06 풀고나서 생각해보니 parseint에 radix 지정하는게 있었다..
public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ca = br.readLine().toCharArray();
        int result = 0;

        if(ca.length == 1 && ca[0] - '0' == 0) {
            System.out.println("0");
        } else {
            for(int i = 0; i < ca.length; i++) {
                result += convert(ca[i], ca.length - i - 1);
            }
            System.out.println(result);
        }
    }

    private static int convert(char num, int n) {
        int pos = (int)Math.pow(16, n);
        if(n == 0) {
            pos = 1;
        }
        if(num - '0' >= 0 && num - '0' < 10) {
            return pos * (num - '0');
        } else {
            return pos * (num - 'A' + 10);
        }
    }
}