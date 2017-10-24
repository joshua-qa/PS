import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String[] oct = {"000", "001", "010", "011", "100", "101", "110", "111"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] binary = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        String str = "";

        for(int i = binary.length-1; i >= 0; i--) {
            str = binary[i] + str;
            if(str.length() == 3) {
                for(int j = 0; j < oct.length; j++) {
                    if(oct[j].equals(str)) {
                        sb.append(j);
                        break;
                    }
                }
                str = "";
            } else if(i == 0 && str.length() < 3) {
                if(str.length() == 1) {
                    str = "00" + str;
                } else {
                    str = "0" + str;
                }
                for(int j = 0; j < oct.length; j++) {
                    if(oct[j].equals(str)) {
                        sb.append(j);
                        break;
                    }
                }
            }
        }

        sb.reverse();
        System.out.print(sb.toString());
    }
}