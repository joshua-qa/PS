import java.util.*;
import java.util.stream.LongStream;
public class SumSquaredDivisors {
	
	public static String listSquared(long m, long n) {
		ArrayList<String> result = new ArrayList<>();

    for(int i = (int)m; i <= (int)n; i++) {
        final int curr = i;
        Long sum = LongStream.rangeClosed(1, i)
                        .filter(v -> curr % v == 0)
                        .map(v -> v * v)
                        .sum();

        if(isSquare(sum)) {
            result.add("[" + curr + ", " + sum + "]");
        }
    }

    return "[" + String.join(", ", result) + "]";
  }

  private static boolean isSquare(long input) {
      long sqrt = (long)Math.sqrt(input);
      return sqrt * sqrt == input;
  }
}