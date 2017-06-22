import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Joshua on 2017-06-22.
 */
public class TwoSum {

    public static void main(String[] args) throws IOException {
        new TwoSum().run();
    }

    private void run() throws IOException {
        int[] input = new int[182140];
        int target = 5;

        try {
            BufferedReader in = new BufferedReader(new FileReader("C:/java/two.txt"));
            String s = in.readLine();
            StringTokenizer st = new StringTokenizer(s, ",");

            for(int i = 0; i < input.length; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            in.close();
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        long start = System.currentTimeMillis();

        int[] result = twoSum2(input, target);
        System.out.println(result[0] + " " + result[1]);
        long end = System.currentTimeMillis();

        System.out.println("실행 시간 : " + ( end - start )/1000.0f);
    }

    // 처음 생각했던 해답. leetcode에 제출해서 AC는 가능했지만 최적해보다 두배정도 걸림. ㅠㅠ
    public int[] twoSum(int[] numbers, int target) {
        int[] array = {-1, -1};
        int temp;
        for(int i = 0; i < numbers.length; i++) {
            temp = Arrays.binarySearch(numbers, i+1, numbers.length, target-numbers[i]);
            if(temp < 0) {
                continue;
            } else {
                array[0] = i+1;
                array[1] = Arrays.binarySearch(numbers, i+1, numbers.length, target-numbers[i])+1;
                break;
            }
        }
        return array;
    }

    //  이 문제에 대한 최적해..
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                break;
            } else if(numbers[left] + numbers[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return new int[] {left+1, right+1};
    }
}
