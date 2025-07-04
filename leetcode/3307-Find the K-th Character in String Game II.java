class Solution {
    public char kthCharacter(long k, int[] operations) {
        if (operations.length == 1) {
            if (operations[0] == 0) {
                return 'a';
            }
            return k == 1 ? 'a' : 'b';
        }
        long startLength = 1;
        int startOperation = -1;
        for (int i = 0; i < operations.length; i++) {
            startLength <<= 1;
            startOperation++;
            if (startLength > k) {
                break;
            }
        }

        int result = (getCharByIndex(operations, startOperation, k - 1L, startLength) % 26) + 'a';
        return (char) result;
    }

    private int getCharByIndex(int[] operations, int currOpIndex, long index, long currSize) {
        if (currOpIndex == -1) {
            return 0;
        }

        long halfSize = currSize / 2L;

        if (index < halfSize) {
            return getCharByIndex(operations, currOpIndex - 1, index, halfSize);
        } else {
            int leftSideChar = getCharByIndex(operations, currOpIndex - 1, index - halfSize, halfSize);
            return operations[currOpIndex] == 0 ? leftSideChar : leftSideChar + 1;
        }
    }
}

//runtime:1 ms
//memory:43.2 MB
