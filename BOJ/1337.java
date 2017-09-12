import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    int n, currLength, ans;
    int[] nums;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        if(n != 0) {
            ans = 1;
        }
        currLength = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] + 1 == nums[i+1]) {
                currLength++;
                ans = Math.max(ans, currLength);
            } else {
                int curr = currLength;
                for(int j = nums[i] + 1; j <= nums[i] + 5 - currLength; j++) {
                    if(Arrays.binarySearch(nums, i+1, nums.length, j) > 0) {
                        curr++;
                    }
                }
                ans = Math.max(ans, curr);
                currLength = 1;
            }
        }

        System.out.print(ans > 4 ? 0 : 5 - ans);
    }
}