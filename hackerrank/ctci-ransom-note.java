import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Solution(String magazine, String note) {
        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        String[] magazineArray = magazine.split(" ");
        String[] noteArray = note.split(" ");
        
        for(String s : magazineArray) {
            if(magazineMap.containsKey(s)) {
                magazineMap.put(s, magazineMap.get(s) + 1);
            } else {
                magazineMap.put(s, 1);
            }
        }

        for(String s : noteArray) {
            if(noteMap.containsKey(s)) {
                noteMap.put(s, noteMap.get(s) + 1);
            } else {
                noteMap.put(s, 1);
            }
        }
    }

    public boolean solve() {
        for(String s : noteMap.keySet()) {
            if(magazineMap.get(s) < noteMap.get(s)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}