import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * Created by jgchoi.qa on 2017. 5. 31..
 */
public class Main {
    static Vector<String> vc = new Vector<>();
    static int[][] snsMap;
    static List<Integer> friendNumArray = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        readTextFile();

        String input = br.readLine();
        System.out.println(myFriend(input));
        System.out.println(friendFriend(input));
    }

    private static String friendFriend(String input) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < friendNumArray.size(); i++) {
            for(int j = 0; j < vc.size(); j++) {
                if(snsMap[friendNumArray.get(i)][j] == 1 && sb.indexOf(vc.get(j)) == -1 && !vc.get(j).equals(input) && friendNumArray.indexOf(j) == -1) {
                    sb.append(vc.get(j) + " ");
                }
            }
        }

        return sb.toString();
    }

    private static String myFriend(String input) {
        int index = vc.indexOf(input);
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < vc.size(); i++) {
            if(snsMap[index][i] == 1) {
                sb.append(vc.get(i) + " ");
                friendNumArray.add(i);
            }
        }

        return sb.toString();
    }

    private static void readTextFile() throws IOException {
        Path path = Paths.get("C:/java/sns-friends.txt");
        int count = (int)Files.lines(path, StandardCharsets.UTF_8).count();
        snsMap = new int[count][count];

        try(Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.forEach(s -> {
                if(vc.indexOf(s.split(" ")[0]) == -1) {
                    vc.add(s.split(" ")[0]);
                }
                if(vc.indexOf(s.split(" ")[1]) == -1) {
                    vc.add(s.split(" ")[1]);
                }
                int i = vc.indexOf(s.split(" ")[0]);
                int j = vc.indexOf(s.split(" ")[1]);
                snsMap[i][j] = 1;
                snsMap[j][i] = 1;
            });
        }
    }
}