import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, m, s;
    final int MAX = 20;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(!s.equals("all") && !s.equals("empty")) {
                m = Integer.parseInt(st.nextToken());
            } else if(s.equals("all")) {
                all();
                continue;
            } else if(s.equals("empty")) {
                empty();
                continue;
            }

            if(s.equals("add")) {
                add();
            } else if(s.equals("check")) {
                sb.append(check() + "\n");
            } else if(s.equals("remove")) {
                remove();
            } else {
                toggle();
            }
        }

        System.out.print(sb);
    }

    private void empty() {
        s &= 0;
    }

    private void all() {
        for(int i = 1; i <= MAX; i++) {
            s = s | (1 << i);
        }
    }

    private void add() {
        s = s | (1 << m);
    }

    private int check() {
        if((s & (1 << m)) != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void remove() {
        s = s & ~(1 << m);
    }

    private void toggle() {
        s = s ^ (1 << m);
    }
}