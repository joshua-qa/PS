package Joshua.PS;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int temp = 0;

        for(int i = 0; i < input.length(); i++) {
            // input-97
            temp = (int)input.charAt(i) - 97;
            if(alphabet[temp] == -1) {
                alphabet[temp] = i;
            }
        }

        for(int a : alphabet ) {
            System.out.print(a + " ");
        }
    }
}