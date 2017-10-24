import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> enterList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        String s = "";
        char[] c;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            c = st.nextToken().toCharArray();
            if (c[0] == 'e') {
                enterList.add(s);
            } else {
                enterList.remove(enterList.indexOf(s));
            }
        }

        enterList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2) * -1;
            }
        });

        for(String str : enterList) {
            sb.append(str + "\n");
        }

        System.out.print(sb.toString());
    }
}