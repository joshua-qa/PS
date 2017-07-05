import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int temp = 0;
        int a, b;

        while(sc.hasNextInt()) {
            a = sc.nextInt();
            b = sc.nextInt();
            temp = a + b;
            System.out.println(temp);
        }
    }
}