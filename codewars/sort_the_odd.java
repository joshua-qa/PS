import java.util.*;

// Stream으로 ArrayList없이 할 수 있음.
public class Kata {
  public static int[] sortArray(int[] array) {
    ArrayList<Integer> odds = new ArrayList<>();

    for(int i : array) {
        if(i % 2 != 0) {
            odds.add(i);
        }
    }

    Collections.sort(odds);

    for(int i = 0, j = 0; i < array.length; i++) {
        if(array[i] % 2 != 0) {
            array[i] = odds.get(j++);
        }
    }
    return array;
  }
}