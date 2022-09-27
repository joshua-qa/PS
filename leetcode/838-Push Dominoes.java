// 55ms. 미디엄을 이렇게 길게 풀면 안되는데... BFS 연습하는 느낌으로 접근했다.
class Solution {
    public String pushDominoes(String dominoes) {
        Queue<Pair<Integer, Character>> queue = new LinkedList<>();
        int length = dominoes.length();
        char[] dominoLine = dominoes.toCharArray();

        for (int i = 0; i < length; i++) {
            switch (dominoLine[i]) {
                case 'L':
                case 'R':
                    queue.offer(new Pair<>(i, dominoLine[i]));
                    break;
                default:
                    break;
            }
        }

        int prevProcessedBlock = -1;
        while (!queue.isEmpty()) {
            Pair<Integer, Character> domino = queue.poll();
            int index = domino.getKey();
            if (domino.getValue() == 'L') {
                if (index == 0) {
                    continue;
                }
                if (index == 1 && dominoLine[0] == '.') {
                    dominoLine[0] = 'L';
                    prevProcessedBlock = 0;
                    continue;
                }
                if (dominoLine[index-1] == '.' && (dominoLine[index-2] != 'R' || prevProcessedBlock == index-2)) {
                    dominoLine[index-1] = 'L';
                    prevProcessedBlock = index-1;
                    queue.offer(new Pair<>(index-1, 'L'));
                }
            } else {
                if (index == length-1) {
                    continue;
                }
                if (index == length-2 && dominoLine[length-1] == '.') {
                    dominoLine[length-1] = 'R';
                    prevProcessedBlock = length-1;
                    continue;
                }
                if (dominoLine[index+1] == '.' && dominoLine[index+2] != 'L') {
                    dominoLine[index+1] = 'R';
                    prevProcessedBlock = index+1;
                    queue.offer(new Pair<>(index+1, 'R'));
                }
            }
        }

        return new String(dominoLine);
    }
}
