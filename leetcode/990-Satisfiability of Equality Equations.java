// 1ms. 안써서 반쯤 까먹었던 유니온 파인드를 복습할 수 있었다.
class Solution {
    private int[] group;
    public boolean equationsPossible(String[] equations) {
        group = new int[26];
        for (int i = 0; i < 26; i++) {
            group[i] = i;
        }

        for (String equation : equations) {
            if (!equation.contains("==")) {
                continue;
            }
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (find(a) != find(b)) {
                add(a, b);
            }
        }

        for (String equation : equations) {
            if (equation.contains("==")) {
                continue;
            }
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (find(a) == find(b)) {
                return false;
            }
        }
        return true;
    }

    private void add(int curr, int target) {
        curr = find(curr);
        target = find(target);
        group[target] = curr;
    }

    private int find(int curr) {
        if (group[curr] == curr) {
            return curr;
        }

        return group[curr] = find(group[curr]);
    }
}
