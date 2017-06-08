import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] user = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0, result = 0, temp = 0;

        while(st.hasMoreTokens()) {
            user[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(user);

        for(int i = 0; i < m; i++) {
            result += temp + user[i];
            temp += user[i];
        }

        System.out.print(result);
    }
}