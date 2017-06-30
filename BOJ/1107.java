package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    ArrayList<Integer> number = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int curr = 0, min = 999999;

        for(int i = 0; i < 10; i++) {
            number.add(i);
        }

        if(m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                number.remove(number.indexOf(Integer.parseInt(st.nextToken())));
            }
        }

        for(int i = 0; i <= 1000000; i++) {
            if(!judge(i)) {
                continue;
            }
            if(min > Math.abs(i-n)) {
                min = Math.abs(i-n);
                curr = i;
            }
        }

        int length = String.valueOf(curr).length();
        int worst = Math.abs(n - 100);
        if(n == 100) {
            System.out.println("0");
        } else {
            System.out.println(Math.min(length + min, worst));
        }
    }

    private boolean judge(int n) {
        char[] input = String.valueOf(n).toCharArray();
        for(int i = 0; i < input.length; i++) {
            if(!number.contains(input[i] - '0')) {
                return false;
            }
        }

        return true;
    }
}