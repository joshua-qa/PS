// 96ms. 자력으로 푼 것에 의의를...
class Solution {
    List<List<String>> result;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }

        int wordListSize = wordList.size();
        Map<String, Integer> wordTransformCount = new HashMap<>();
        Map<String, Set<String>> transformSet = new HashMap<>();

        result = new ArrayList<>();
        Queue<Pair<String, List<String>>> transformQueue = new ArrayDeque<>();
        // bfs
        transformQueue.offer(makePair(beginWord, new ArrayList<>()));
        while (!transformQueue.isEmpty()) {
            Pair<String, List<String>> currentWord = transformQueue.poll();
            int currentTransformSize = currentWord.getValue().size();
            if (currentTransformSize > wordListSize+1) {
                continue;
            }
            if (currentWord.getKey().equals(endWord)) {
                continue;
            }

            for (String word : wordList) {
                int wordMinCount = wordTransformCount.getOrDefault(word, Integer.MAX_VALUE);
                if (wordMinCount <= currentTransformSize-1 || currentWord.getValue().contains(word) || !isAvailable(currentWord.getKey(), word)) {
                    continue;
                }
                if (wordMinCount == currentTransformSize) {
                    if (transformSet.containsKey(word)) {
                        transformSet.get(word).add(currentWord.getKey());
                    } else {
                        Set<String> set = new HashSet<>();
                        set.add(currentWord.getKey());
                        transformSet.put(word, set);
                    }
                    continue;
                }
                wordTransformCount.putIfAbsent(word, currentTransformSize);
                Set<String> set = new HashSet<>();
                set.add(currentWord.getKey());
                transformSet.put(word, set);
                transformQueue.offer(makePair(word, new ArrayList<>(currentWord.getValue())));
            }
        }

        if (transformSet.containsKey(endWord)) {
            Queue<Pair<String, List<String>>> resultQueue = new ArrayDeque<>();
            List<String> path = new ArrayList<>();
            path.add(endWord);
            resultQueue.offer(new Pair<>(endWord, path));
            while (!resultQueue.isEmpty()) {
                Pair<String, List<String>> node = resultQueue.poll();
                if (node.getKey().equals(beginWord)) {
                    Collections.reverse(node.getValue());
                    result.add(node.getValue());
                    continue;
                }
                Set<String> resultPaths = transformSet.get(node.getKey());
                for (String nextNode : resultPaths) {
                    List<String> nextPath = new ArrayList<>(node.getValue());
                    nextPath.add(nextNode);
                    resultQueue.offer(new Pair<>(nextNode, nextPath));
                }
            }
        }
        return result;
    }

    private Pair<String, List<String>> makePair(String word, List<String> transformList) {
        transformList.add(word);
        return new Pair<>(word, transformList);
    }

    private boolean isAvailable(String currentWord, String targetWord) {
        int diff = 0, length = currentWord.length();
        for (int i = 0; i < length; i++) {
            if (currentWord.charAt(i) != targetWord.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}
