import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    int n, m, stick;
    int[] nums;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            stick = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            nums = new int[m];

            int ans = 0;

            int center = stick / 2;
            for(int j = 0; j < m; j++) {
                nums[j] = Integer.parseInt(br.readLine());
                if(nums[j] < center) {
                    ans = Math.max(ans, nums[j]);
                } else {
                    ans = Math.max(ans, stick-nums[j]);
                }

            }
            Arrays.sort(nums);

            int ansMax = m == 1 ? Math.max(nums[0], stick-nums[0]) : 0;
            for(int j = 1; j < m; j++) {
                int meet = (nums[j] - nums[j-1]) / 2;
                int left = meet * 2 + nums[j-1];
                int right = meet * 2 + stick - nums[j];
                if((nums[j] - nums[j-1]) % 2 != 0) {
                    left++;
                    right++;
                }

                ansMax = Math.max(ansMax, Math.max(left, right));
            }

            sb.append(ans + " " + ansMax + "\n");
        }
        System.out.print(sb);
    }
}