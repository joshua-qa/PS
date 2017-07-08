import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            char[] ca = sc.nextLine().toCharArray();
            if(ca.length == 0) {
                break;
            }
            int s=0, d=0, n=0, b=0;

            for(int i = 0; i < ca.length; i++) {
                if(ca[i] - ' ' == 0) {
                    b++;
                } else if(ca[i] - '0' >= 0 && ca[i] - '0' <= 9) {
                    n++;
                } else if(ca[i] - 'a' >= 0 && ca[i] - 'a' <= 25) {
                    s++;
                } else if(ca[i] - 'A' >= 0 && ca[i] - 'A' <= 25) {
                    d++;
                }
            }

            System.out.println(s + " " + d + " " + n + " " + b);
        }
    }
}