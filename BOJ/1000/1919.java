import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int n;
    int[] firstChar = new int[26];
    int[] secondChar = new int[26];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        for(char c : first) {
            firstChar[c - 'a']++;
        }
        for(char c : second) {
            secondChar[c - 'a']++;
        }

        for(int i = 0; i < firstChar.length; i++) {
            n += firstChar[i] >= secondChar[i] ? firstChar[i] - secondChar[i] : secondChar[i] - firstChar[i];
        }

        System.out.print(n);
    }
}