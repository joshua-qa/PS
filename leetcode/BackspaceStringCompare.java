import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
        System.out.println(backspaceCompare("a#c", "b"));
    }

    // 별로 맘에 들지 않아 다시 풀어야함. 1ms
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sEditor = new Stack<>();
        Stack<Character> tEditor = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!sEditor.isEmpty()) {
                    sEditor.pop();
                }
            } else {
                sEditor.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (!tEditor.isEmpty()) {
                    tEditor.pop();
                }
            } else {
                tEditor.push(c);
            }
        }
        while (!sEditor.isEmpty() && !tEditor.isEmpty()) {
            if (sEditor.pop() != tEditor.pop()) {
                return false;
            }
        }
        return sEditor.isEmpty() && tEditor.isEmpty();
    }
}
