import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int[] alphabet = new int[26];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while((s = br.readLine()) != null) {
            char[] line = s.toCharArray();

            for(char c : line) {
                if(c >= 97 && c <= 122) {
                    alphabet[c - 'a']++;
                }
            }
        }

        int max = 0;
        for(int i : alphabet) {
            if(max < i) {
                max = i;
            }
        }

        for(int i = 0; i < alphabet.length; i++) {
            if(max == alphabet[i]) {
                sb.append((char)(i+97));
            }
        }

        System.out.print(sb);
    }
}