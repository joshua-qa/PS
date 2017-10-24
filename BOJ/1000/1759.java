import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    private static int t;
    private static char[] aeiou = {97, 101, 105, 111, 117};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[] alphabet = new char[c];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabet);

        rec(-1, alphabet, 1, "");
        sb.append("\n");
        System.out.print(sb.toString());
    }

    private static void rec(int i, char[] alphabet, int l, String str) {
        if(l == t+1) {
            int judgeCount = judge(str);
            if(judgeCount > 0 && str.length() - judgeCount > 1) {
                sb.append(str + "\n");
            }
            return;
        }

        for(int n = i+1; n < alphabet.length - t + l; n++) {
            rec(n, alphabet, l+1, str + alphabet[n]);
        }
    }

    private static int judge(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < aeiou.length; j++) {
                if(s.charAt(i) == aeiou[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}