import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    int keyLength, textLength, lineLength;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String s = br.readLine();
        Key[] keys = new Key[str.length()];
        keyLength = keys.length;

        for(int i = 0; i < str.length(); i++) {
            keys[i] = new Key(i, str.charAt(i));
        }

        Arrays.sort(keys, new Comparator<Key>() {
            @Override
            public int compare(Key o1, Key o2) {
                if(o1.c != o2.c) {
                    return o1.c - o2.c;
                } else {
                    return o1.index - o2.index;
                }
            }
        });

        int count = 0;
        textLength = s.length();
        lineLength = (textLength % keyLength == 0) ? textLength / keyLength : textLength / keyLength + 1;

        char[][] text = new char[lineLength][keyLength];
        for(int i = 0; i < keyLength; i++) {
            for(int j = 0; j < lineLength; j++) {
                text[j][i] = s.charAt(count++);
            }
        }

        for(int i = 0; i < lineLength; i++) {
            char[] ca = new char[keyLength];
            for(int j = 0; j < keyLength; j++) {
                if(text[i][keys[j].index] != 0) {
                    ca[keys[j].index] = text[i][j];
                }
            }
            sb.append(ca);
        }

        System.out.print(sb);
    }
}

class Key {
    int index;
    char c;

    public Key(int index, char c) {
        this.index = index;
        this.c = c;
    }
}