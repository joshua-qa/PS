class Solution {
    private int fast, lazy, first, second;

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        fast = 99999;
        first = firstPlayer;
        second = secondPlayer;
        int[] players = new int[n];
        for (int i = 0; i < players.length; i++) {
            players[i] = i + 1;
        }
        phase1(players, 1);
        return new int[]{fast, lazy};
    }

    private void phase1(int[] players, int currRound) {
        int halfSize = (players.length + 1) / 2;
        boolean isFirst = false;
        boolean isSecond = false;
        for (int i = 0; i < halfSize; i++) {
            int leftPlayer = players[i];
            int rightPlayer = players[players.length - 1 - i];
            if (leftPlayer == first || rightPlayer == first) {
                isFirst = true;
            }
            if (leftPlayer == second || rightPlayer == second) {
                isSecond = true;
            }
            if ((leftPlayer == first && rightPlayer == second) || (leftPlayer == second && rightPlayer == first)) {
                fast = Math.min(fast, currRound);
                lazy = Math.max(lazy, currRound);
                return;
            }
        }
        if (isFirst && isSecond) {
            int[] nextRound = new int[halfSize];
            phase2(players, nextRound, currRound + 1, 0);
        }
    }

    private void phase2(int[] players, int[] nextRound, int currRound, int currIndex) {
        if (currIndex == nextRound.length) {
            int[] newRound = new int[nextRound.length];
            System.arraycopy(nextRound, 0, newRound, 0, nextRound.length);
            Arrays.sort(newRound);
            phase1(newRound, currRound);
            return;
        }
        // select
        nextRound[currIndex] = players[currIndex];
        phase2(players, nextRound, currRound, currIndex + 1);
        if (players.length % 2 == 1 && currIndex == nextRound.length - 1) {
            return;
        }
        nextRound[currIndex] = players[players.length - 1 - currIndex];
        phase2(players, nextRound, currRound, currIndex + 1);
    }
}
