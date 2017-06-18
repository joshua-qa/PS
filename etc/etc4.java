package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] truck = new int[n];
        int[] w = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < k; j++) {
            w[j] = Integer.parseInt(st.nextToken());
        }

        int[] test = solution(truck, w);

        for(int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
    }

    // 원래 코드가 truck 68000, w 47520 input으로 0.98초 정도 걸렸는데 새로 구현한 코드는 0.45초 정도.
    // truck 136000, w 95040 input으로도 1.76초 걸리는걸 보면 진짜 빨라진건데 더 최적화 할 수 있는건지 알아봐야겠다.
    // 한번 더 고친 코드에서는 같은 input으로 1.27~1.32초 걸린다. 세그먼트 트리를 쓰면 더 빨라질까...

    public static int[] solution(int[] truck, int[] w) {
        int[] answer = new int[w.length];
        Arrays.fill(answer, -1);
        int first = 0;

        for(int i = 0; i < w.length; i++) {
            if(i > 0 && w[i] >= w[i-1]) {
                if(answer[i-1] == -1) {
                    answer[i] = -1;
                    continue;
                }
                first = answer[i-1] - 1;
            } else {
                first = 0;
            }
            for(int j = first; j < truck.length; j++) {
                if(truck[j] == 0 || w[i] > truck[j]) {
                    continue;
                } else if(w[i] <= truck[j]) {
                    truck[j] -= w[i];
                    answer[i] = j+1;
                    break;
                }
            }
        }
        return answer;
    }
}