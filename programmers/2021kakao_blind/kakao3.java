import java.util.*;
class Solution {

    Table[][][][] tables;
    Map<String, Integer> lang;
    Map<String, Integer> part;
    Map<String, Integer> old;
    Map<String, Integer> food;
    public int[] solution(String[] info, String[] query) {
        init();
        for (String user : info) {
            parseAndAdd(user.split(" "));
        }

        int[] answer = new int[query.length];
        int index = 0;
        sort();
        for (String queryString : query) {
            String andRemoveString = queryString.replace(" and ", " ");
            String[] parsedString = andRemoveString.split(" ");
            answer[index++] = getQueryResult(parsedString);
        }

        return answer;
    }

    private int getQueryResult(String[] parsedString) {
        int langIndex = lang.get(parsedString[0]);
        int partIndex = part.get(parsedString[1]);
        int oldIndex = old.get(parsedString[2]);
        int foodIndex = food.get(parsedString[3]);
        int score = Integer.parseInt(parsedString[4]);
        Table queryResult = tables[langIndex][partIndex][oldIndex][foodIndex];
        return getCount(queryResult, score);
    }

    public int getCount(Table queryResult, int filter) {
        int size = queryResult.scores.size();
        int min = 0;
        int max = size;
        int mid = 0;

        while (min < max) {
            mid = (min + max) / 2;
            if (filter <= queryResult.scores.get(mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return size - max;
    }

    private void init() {
        tables = new Table[4][3][3][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        tables[i][j][k][l] = new Table();
                    }
                }
            }
        }
        lang = new HashMap<>();
        part = new HashMap<>();
        old = new HashMap<>();
        food = new HashMap<>();
        lang.put("-", 0);
        lang.put("cpp", 1);
        lang.put("java", 2);
        lang.put("python", 3);

        part.put("-", 0);
        part.put("backend", 1);
        part.put("frontend", 2);

        old.put("-", 0);
        old.put("junior", 1);
        old.put("senior", 2);

        food.put("-", 0);
        food.put("chicken", 1);
        food.put("pizza", 2);
    }

    private void sort() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        tables[i][j][k][l].sort();
                    }
                }
            }
        }
    }

    private void parseAndAdd(String[] info) {
        int langIndex = lang.get(info[0]);
        int partIndex = part.get(info[1]);
        int oldIndex = old.get(info[2]);
        int foodIndex = food.get(info[3]);
        int score = Integer.parseInt(info[4]);

        for (int i = 0; i < 2; i++) {
            int currentLangIndex = (i == 0) ? 0 : langIndex;
            for (int j = 0; j < 2; j++) {
                int currentPartIndex = (j == 0) ? 0 : partIndex;
                for (int k = 0; k < 2; k++) {
                    int currentOldIndex = (k == 0) ? 0 : oldIndex;
                    for (int l = 0; l < 2; l++) {
                        int currentFoodIndex = (l == 0) ? 0 : foodIndex;
                        tables[currentLangIndex][currentPartIndex][currentOldIndex][currentFoodIndex].add(score);
                    }
                }
            }
        }
    }
}

class Table {
    public final List<Integer> scores;

    public Table() {
        this.scores = new ArrayList<>();
    }

    public void add(int score) {
        this.scores.add(score);
    }

    public void sort() {
        Collections.sort(scores);
    }
}