import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        String[][] student = new String[n][4];
        for(int i = 0; i < n; i++) {
            student[i] = br.readLine().split(" ");
        }

        Arrays.sort(student, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(!o1[1].equals(o2[1])) {
                    return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
                } else if(o1[1].equals(o2[1]) && !o1[2].equals(o2[2])) {
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                } else if(o1[1].equals(o2[1]) && o1[2].equals(o2[2]) && !o1[3].equals(o2[3])) {
                    return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });

        for(int i = 0; i < n; i++) {
            sb.append(student[i][0] + "\n");
        }

        System.out.print(sb.toString());
    }
}