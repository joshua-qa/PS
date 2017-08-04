import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    StringBuilder sb = new StringBuilder();
    ArrayList<String> dic = new ArrayList<>();
    boolean flag;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ca = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            dic.add(br.readLine());
        }

        for(int i = 0; i < 26; i++) {
            for(char c : ca) {
                char temp;
                if((int)c + i > 122) {
                    temp = (char)(c + i - 26);
                } else {
                    temp = (char) (c + i);
                }
                sb.append(temp);
            }
            for(String s : dic) {
                if(sb.indexOf(s) > -1) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                System.out.print(sb);
                break;
            } else {
                sb.delete(0, sb.length());
            }
        }
    }
}