import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    long[] cardArray;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        cardArray = new long[n];

        for(int i = 0; i < n; i++) {
            cardArray[i] = Long.parseLong(br.readLine());
        }

        Arrays.parallelSort(cardArray);

        int currCount = 1;
        int max = 0;
        long curr = cardArray[n-1];
        long maxNum = 0;

        for(int i = n-2; i >= 0; i--) {
            if(cardArray[i] == curr) {
                currCount++;
            } else if(cardArray[i] != curr) {
                if(currCount >= max) {
                    maxNum = curr;
                    max = currCount;
                }

                curr = cardArray[i];

                currCount = 1;
            }
        }
        if(currCount >= max) {
            maxNum = curr;
            max = currCount;
        }

        System.out.println(maxNum);
    }
}