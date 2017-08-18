import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    StringTokenizer st;
    int[] array, left, right;
    int n, k;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        array = new int[n];
        left = new int[n];
        right = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int center = array[n / 2];
        int l = 0, r = 0;
        for(int i : array) {
            if(i <= center) {
                left[l++] = i;
            } else {
                right[r++] = i;
            }
        }

        if(l >= k) {
            Arrays.sort(left, 0, l);
            System.out.println(left[k-1]);
        } else {
            Arrays.sort(right, 0, r);
            System.out.println(right[k - l - 1]);
        }
    }
}