import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine())+1;
        String s = Integer.toBinaryString(n);
        char[] ca = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < ca.length; i++) {
            if(ca[i] == '0') {
                sb.append('4');
            } else {
                sb.append('7');
            }
        }

        System.out.print(sb);
    }
}