import java.util.*;

// 더 효율적으로 푸는 솔루션을 보고 잘 배웠으니 다음에 다시 풀어봐야함.
public class DuplicateEncoder {
	static String encode(String word){
    Map<Character, Integer> count = new HashMap<>();
    
    char[] ca = word.toLowerCase().toCharArray();
    
    for(char c : ca) {
      if(count.containsKey(c)) {
        count.put(c, count.get(c) + 1);
      } else {
        count.put(c, 1);
      }
    }
    
    for(int i = 0; i < ca.length; i++) {
      if(count.get(ca[i]) == 1) {
        ca[i] = '(';
      } else {
        ca[i] = ')';
      }
    }
    return String.valueOf(ca);
  }
}