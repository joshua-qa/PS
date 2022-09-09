// 250ms. 생각보다 좀 어렵게 느껴진 문제..
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int length = properties.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Pair<>(properties[i][0], properties[i][1]));
                continue;
            }

            if (stack.peek().getKey() == properties[i][0]) {
                stack.push(new Pair<>(properties[i][0], properties[i][1]));
                continue;
            }

            while (!stack.isEmpty() && stack.peek().getKey() < properties[i][0] && stack.peek().getValue() < properties[i][1]) {
                count++;
                stack.pop();
            }
            stack.push(new Pair<>(properties[i][0], properties[i][1]));
        }

        if (stack.isEmpty()) {
            return count;
        }
        Pair<Integer, Integer> end = stack.pop();
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> peek = stack.peek();
            if (end.getKey() > peek.getKey() && end.getValue() > peek.getValue()) {
                count++;
                stack.pop();
                continue;
            }

            if (end.getKey() == peek.getKey() && end.getValue() < peek.getValue()) {
                end = stack.pop();
                continue;
            }

            stack.pop();
        }
        return count;
    }
}
