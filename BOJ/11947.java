import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    String s = "9999999999";
    String rs = "4999999999";
    String rs2 = "5000000000";
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            int size = String.valueOf(inputNum).length();
            sb.append(solve(inputNum, size) + "\n");
        }

        System.out.print(sb);
    }

    private long solve(int inputNum, int size) {
        int a = 1;
        long max = 0;
        for(int i = 0; i < String.valueOf(inputNum).length()-1; i++) {
            a *= 10;
        }

        long sn = Long.parseLong(rs.substring(0, size));
        long sn2 = Long.parseLong(rs2.substring(0, size));
        if(inputNum < sn) {
            max = inputNum * cal(inputNum, size);
        } else {
            max = sn * sn2;
        }

        return max;
    }

    private long cal(int inputNum, int size) {
        long reverse = Long.parseLong(s.substring(0, size));
        return reverse - inputNum;
    }
}