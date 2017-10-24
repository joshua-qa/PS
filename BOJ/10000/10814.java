import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    StringTokenizer st;
    ArrayList<Member> memberList = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            memberList.add(new Member(Integer.parseInt(st.nextToken()), i, st.nextToken()));
        }
        
        Collections.sort(memberList);
        for(Member m : memberList) {
            sb.append(m.age + " " + m.name + "\n");
        }

        System.out.print(sb.toString());
    }
}

class Member implements Comparable {
    int age;
    int index;
    String name;

    public Member(int age, int index, String name) {
        this.age = age;
        this.index = index;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        int compareAge = ((Member) o).age;
        int compareIndex = ((Member) o).index;

        if(this.age != compareAge) {
            return this.age - compareAge;
        } else {
            return this.index - compareIndex;
        }
    }
}