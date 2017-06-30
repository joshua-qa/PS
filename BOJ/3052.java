package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    int[] list = new int[10];
    final int NMG = 42;

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(judge());
    }

    private int judge() {
        List<Integer> result = new ArrayList<>();
        int temp = 0;

        for(int i : list) {
            temp = i % NMG;
            if(!result.contains(temp)) {
                result.add(temp);
            }
        }

        return result.size();
    }
}