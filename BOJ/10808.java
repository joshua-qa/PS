import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Joshua on 2017-06-12.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int[] result = new int[26];

        for(char c:input) {
            result[c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
