import java.lang.StringBuilder;
class Solution{

  static String toCamelCase(String s){
    boolean flag = false;
    StringBuilder sb = new StringBuilder();
    
    for(char c : s.toCharArray()) {
      if(c == '-' || c == '_') {
        flag = true;
        continue;
      } else if(flag) {
        sb.append(String.valueOf(c).toUpperCase());
        flag = false;
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}