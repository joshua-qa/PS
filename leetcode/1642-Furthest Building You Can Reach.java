class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int result = 0;
        int size = heights.length;
        PriorityQueue<Integer> needBricksQueue = new PriorityQueue<>(Comparator.reverseOrder());

        while (result != size-1) {
            // case 1 (>=)
            if (heights[result] >= heights[result+1]) {
                result++;
                continue;
            }
            // case 2 (<)
            int needBlocksCount = heights[result+1] - heights[result];
            if (bricks >= needBlocksCount) {
                bricks -= needBlocksCount;
                needBricksQueue.offer(needBlocksCount);
                result++;
                continue;
            }

            // case 2-1 (<, not enough block)
            if (ladders == 0) {
                // case 2-1-1 (not enough ladder)
                break;
            }
            if (!needBricksQueue.isEmpty() && needBlocksCount < needBricksQueue.peek()) {
                bricks += needBricksQueue.poll();
                ladders--;
                if (bricks >= needBlocksCount) {
                    bricks -= needBlocksCount;
                    needBricksQueue.offer(needBlocksCount);
                    result++;
                }
            } else {
                ladders--;
                result++;
            }
        }
        return result;
    }
}