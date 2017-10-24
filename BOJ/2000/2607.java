package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        int result = 0;
        String target = scan.nextLine();
        String[] wordArray = new String[N-1];

        for (int i = 0; i < N-1; i++) {
            wordArray[i] = scan.nextLine();
        }

        StringBuffer sb = new StringBuffer();
        int containsCount;

        for (int a = 0; a < N-1; a++) {
            containsCount = 0;
            sb.append(wordArray[a]);
            for (int b = 0; b < target.length(); b++) {
                int temp = sb.indexOf(target.substring(b, b+1));
                if (temp != -1) {
                    containsCount++;
                    sb.deleteCharAt(temp);
                }
            }
            if (containsCount == target.length() && wordArray[a].length()-1 == target.length()) {
                result++;
            } else if (containsCount == target.length()-1 && wordArray[a].length()+1 == target.length()) {
                result++;
            } else if (containsCount == target.length()-1 && wordArray[a].length() == target.length()) {
                result++;
            } else if (containsCount == target.length() && wordArray[a].length() == target.length()) {
                result++;
            }
            sb.delete(0, sb.length());
        }

        System.out.println(result);
    }
}