import java.io.*;
import java.util.*;

public class Main {
    ArrayList<Integer> matchList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();

        int[] pi = pre(P);

        int n = T.length;
        int m = P.length;
        int j = 0;
        for(int i = 0; i < n; i++) {
            while(j > 0 && T[i] != P[j]) {
                j = pi[j - 1];
            }
            if(T[i] == P[j]) {
                if(j == m - 1) {
                    matchList.add(i - m + 2);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        sb.append(matchList.size() + "\n");
        for(int k : matchList) {
            sb.append(k + " ");
        }

        System.out.print(sb);
    }

    private int[] pre(char[] p) {
        int[] pi = new int[p.length];

        int j = 0;
        for(int i = 1; i < pi.length; i++) {
            while(j > 0 && p[i] != p[j]) {
                j = pi[j-1];
            }
            if(p[i] == p[j]) {
                pi[i] = j+1;
                j += 1;
            } else {
                pi[i] = 0;
            }
        }

        return pi;
    }
}