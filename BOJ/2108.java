import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    private int[] list;
    private HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        list = new int[n];
        int ave = 0;
        int min = Integer.MAX_VALUE, mincount = 0, second = Integer.MAX_VALUE;
        int start = 4001, end = -4001;

        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
            ave += list[i];
            if(list[i] < start) {
                start = list[i];
            }
            if(list[i] > end) {
                end = list[i];
            }
            if(hm.get(list[i]) == null) {
                hm.put(list[i], 1);
            } else {
                int temp = hm.get(list[i]);
                hm.replace(list[i], temp+1);
            }
        }
        for(int i = start; i <= end; i++) {
            if(hm.get(i) == null) {
                continue;
            } else {
                if(mincount == 0 || mincount < hm.get(i).intValue()) {
                    min = i;
                    mincount = hm.get(i).intValue();
                    second = Integer.MAX_VALUE;
                } else if(mincount == hm.get(i).intValue()) {
                    if(second != Integer.MAX_VALUE && i > second) {
                        continue;
                    }
                    if(min < i) {
                        second = i;
                    } else {
                        second = min;
                        min = i;
                    }
                }
            }
        }

        Arrays.sort(list);
        double temp = (double)ave / (double)n;
        sb.append(String.format("%.0f", temp) + "\n");
        sb.append(list[n/2] + "\n");
        if(second != Integer.MAX_VALUE) {
            sb.append(second + "\n");
        } else {
            sb.append(min + "\n");
        }
        sb.append(list[n-1] - list[0] + "\n");

        System.out.print(sb.toString());
    }
}