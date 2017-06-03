import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = new int[4];
        int[] out = new int[4];
        int[] current = new int[4];
        int max;

        for(int i = 0; i < 4; i++) {
            String input = br.readLine();
            in[i] = Integer.parseInt(input.split(" ")[1]);
            out[i] = Integer.parseInt(input.split(" ")[0]);
        }

        current[0] = in[0];
        max = current[0];

        for(int j = 1; j < 4; j++) {
            current[j] = current[j-1] + (in[j] - out[j]);
            if(max < current[j]) {
                max = current[j];
            }
        }

        System.out.println(max);
    }
}