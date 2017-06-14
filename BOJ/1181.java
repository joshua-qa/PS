package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Joshua on 2017-06-14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        List<String> wordList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            if(!wordList.contains(temp)) {
                wordList.add(temp);
            }
        }

        Comparator<String> wordSort = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        };

        Collections.sort(wordList, wordSort);

        for(int i = 0; i < wordList.size(); i++) {
            sb.append(wordList.get(i) + "\n");
        }

        System.out.print(sb.toString());
    }
}
