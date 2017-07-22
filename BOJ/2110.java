import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private int N, M, result;
    private int[] lan;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        lan = new int[N];

        for(int i = 0; i < N; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lan);
        int min = lan[0];
        int max = lan[N-1];

        rec(min, (min+max) / 2, max);
        System.out.print(result);
    }

    private void rec(int min, int mid, int max) {
        if(min > max) {
            result = mid;
            return;
        }
        int curr = lan[0];
        int remain = M-1;
        int equalCount = 0, i = 1;

        while(curr <= lan[N-1] && i < N && remain > 0) {
            if(lan[i] == curr+mid) {
                equalCount++;
                remain--;
                curr = lan[i];
            } else if(lan[i] > curr+mid) {
                remain--;
                curr = lan[i];
            }
            i++;
        }

        if(remain > 0) {
            rec(min, (min+mid-1)/2, mid-1);
        } else {
            rec(mid+1, (mid+max+1)/2, max);
        }
    }
}