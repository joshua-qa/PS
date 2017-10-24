import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private boolean[] check;
    private int[] pos;
    private int n, k;
    private Queue<Integer> visit = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        int max = Math.max(n, k);
        pos = new int[(max + 1) * 2];
        check = new boolean[(max + 1) * 2];

        rec(n);

        System.out.println(pos[k]);
    }

    private void rec(int st) {
        if(st < 0 || st >= pos.length) {
            return;
        }

        check[st] = true;

        visit.add(st);

        while(!visit.isEmpty()) {
            int start = visit.remove();
            if (start - 1 >= 0) {
                if ((check[start - 1] && pos[start - 1] > pos[start] + 1) || !check[start - 1]) {
                    pos[start - 1] = pos[start] + 1;
                    visit.add(start - 1);
                    check[start - 1] = true;
                }
            }

            if (start + 1 < pos.length) {
                if ((check[start + 1] && pos[start + 1] > pos[start] + 1) || !check[start + 1]) {
                    pos[start + 1] = pos[start] + 1;
                    visit.add(start + 1);
                    check[start + 1] = true;
                }
            }

            if (start * 2 < pos.length) {
                if ((check[start * 2] && pos[start * 2] > pos[start] + 1) || !check[start * 2]) {
                    pos[start * 2] = pos[start] + 1;
                    visit.add(start * 2);
                    check[start * 2] = true;
                }
            }
        }
    }
}