import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> suffix = new ArrayList<>();
        String s = "";

        char[] A = br.readLine().toCharArray();
        for(int i = A.length-1; i >= 0; i--) {
            s = A[i] + s;
            suffix.add(s);
        }

        suffix.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(String suf : suffix) {
            System.out.println(suf);
        }
    }
}