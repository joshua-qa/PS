import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }
    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(convertDecimal(s));
    }

    private int convertDecimal(String s) {
        if(s.indexOf("0x") > -1) {
            return getDecimal(s.substring(2, s.length()), 16);
        } else if(s.charAt(0) == '0') {
            return getDecimal(s, 8);
        } else {
            return getDecimal(s, 10);
        }
    }

    private int getDecimal(String s, int numeral) {
        return Integer.parseInt(s, numeral);
    }
}