// 2ms. 유니온 파인드를 잘 사용하면 된다.
class Solution {
    private int[] parent;
    private Map<Integer, Character> group;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];
        int length = s1.length();
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < length; i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        for (int i = 0; i < 26; i++) {
            find(i);
        }

        group = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (!group.containsKey(parent[i])) {
                group.put(parent[i], (char)('a' + i));
            }
        }

        int baseLength = baseStr.length();
        char[] result = baseStr.toCharArray();
        for (int i = 0; i < baseLength; i++) {
            result[i] = group.getOrDefault(parent[result[i] - 'a'], result[i]);
        }
        return new String(result);
    }

    private void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent > yParent) {
            parent[xParent] = yParent;
            return;
        }
        parent[yParent] = xParent;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
