import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by jgchoi.qa on 2017. 5. 31..
 */
public class Main {
    static List<String> wordList = new ArrayList<>();
    static int failCount = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        readTextFile();
        StringBuffer sb = new StringBuffer();

        int randomWordIndex = (int)(Math.random() * wordList.size());
        char[] wordArray = wordList.get(randomWordIndex).toCharArray();
        maskWord(wordList.get(randomWordIndex).length(), sb);

        while(true) {
            System.out.println("소문자 하나를 입력해주세요.");
            char inputChar = br.readLine().charAt(0);
            wordCheck(wordArray, sb, inputChar);
            if(sb.indexOf("*") == -1) {
                System.out.println("Success");
                break;
            } else if(failCount == 7) {
                System.out.println("Failed");
                break;
            }
        }
    }

    private static void wordCheck(char[] word, StringBuffer sb, char input) {
        boolean flag = false;
        for(int i = 0; i < word.length; i++) {
            if(input == word[i]) {
                sb.replace(i, i+1, String.valueOf(word[i]));
                flag = true;
            }
        }

        if(!flag) {
            failCount++;
            System.out.println("틀렸습니다. 다른 문자를 입력해주세요. 틀린횟수 : " + failCount);
        }
        System.out.println(sb.toString());
    }

    private static void maskWord(int size, StringBuffer sb) {
        for(int i = 0; i < size; i++) {
            sb.append("*");
        }
        System.out.println(sb.toString());
    }

    private static void readTextFile() throws IOException {
        Path path = Paths.get("C:/java/word.txt");

        try(Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.forEach(s -> {
                wordList.add(s);
            });
        }
    }
}