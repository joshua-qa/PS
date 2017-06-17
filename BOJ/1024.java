package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> result = new ArrayList<>();
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        rec(n, l);

        for(int i : result) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> rec(int n, int l) {
        if(l == 101 || l == 1) {
            result.add(-1);
            return result;
        }

        if(n % 2 == 0 && l == 2) {
            rec(n, l+1);
        } else {
            total = 0;
            int temp = n / l;
            int first = temp - (l / 2);
            if(l % 2 == 0) {
                first++;
            }
            if(first < 0) {
                result.add(-1);
                return result;
            }

            for(int i = 0; i < l; i++) {
                total += (first+i);
            }

            if(total != n) {
                rec(n, l+1);
            } else {
                for(int i = 0; i < l; i++) {
                    result.add(first+i);
                }
            }
        }

        return result;
    }
}