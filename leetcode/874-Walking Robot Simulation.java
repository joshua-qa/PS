class Solution {
    // [0,0]에 장애물이 있어도 초기 상태에서 움직이는 것은 가능. '다음 위치'에 장애물이 있는지가 중요함.
    // N : 0, W : 1, S : 2, E : 3
    private Map<Integer, TreeSet<Integer>> obstacleX = new HashMap<>();
    private Map<Integer, TreeSet<Integer>> obstacleY = new HashMap<>();
    private int currX, currY, currDirection;
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        for (int[] obstacle : obstacles) {
            if (!obstacleX.containsKey(obstacle[0])) {
                obstacleX.put(obstacle[0], new TreeSet<>());
            }
            if (!obstacleY.containsKey(obstacle[1])) {
                obstacleY.put(obstacle[1], new TreeSet<>());
            }
            obstacleX.get(obstacle[0]).add(obstacle[1]);
            obstacleY.get(obstacle[1]).add(obstacle[0]);
        }

        for (int i = 0; i < commands.length; i++) {
            if (result < ((currX * currX) + (currY * currY))) {
                result = (currX * currX) + (currY * currY);
            }
            if (commands[i] < 0) {
                currDirection = changePosition(commands[i]);
                continue;
            }

            // commands[i] > 0
            if (!isMoveX()) {
                if (currDirection == 0) {
                    if (!obstacleX.containsKey(currX)) {
                        currY += commands[i];
                        continue;
                    }
                    // N
                    Integer upperBound = obstacleX.get(currX).ceiling(currY + 1);
                    if (upperBound == null || currY + commands[i] < upperBound) {
                        currY += commands[i];
                        continue;
                    }
                    currY = upperBound - 1;
                } else {
                    if (!obstacleX.containsKey(currX)) {
                        currY -= commands[i];
                        continue;
                    }
                    // S
                    Integer lowerBound = obstacleX.get(currX).floor(currY - 1);
                    if (lowerBound == null || currY - commands[i] > lowerBound) {
                        currY -= commands[i];
                        continue;
                    }
                    currY = lowerBound + 1;
                }
                continue;
            }
            if (currDirection == 3) {
                if (!obstacleY.containsKey(currY)) {
                    currX += commands[i];
                    continue;
                }
                // E
                Integer upperBound = obstacleY.get(currY).ceiling(currX + 1);
                if (upperBound == null || currX + commands[i] < upperBound) {
                    currX += commands[i];
                    continue;
                }
                currX = upperBound - 1;
            } else {
                if (!obstacleY.containsKey(currY)) {
                    currX -= commands[i];
                    continue;
                }
                // W
                Integer lowerBound = obstacleY.get(currY).floor(currX - 1);
                if (lowerBound == null || currX - commands[i] > lowerBound) {
                    currX -= commands[i];
                    continue;
                }
                currX = lowerBound + 1;
            }
        }
        if (result < ((currX * currX) + (currY * currY))) {
            result = (currX * currX) + (currY * currY);
        }

        return result;
    }

    private boolean isMoveX() {
        return currDirection == 1 || currDirection == 3;
    }

    private int changePosition(int nextDirection) {
        switch (currDirection) {
            case 0:
                return nextDirection == -2 ? 1 : 3;
            case 1:
                return nextDirection == -2 ? 2 : 0;
            case 2:
                return nextDirection == -2 ? 3 : 1;
            default:
                return nextDirection == -2 ? 0 : 2;
        }
    }
}
