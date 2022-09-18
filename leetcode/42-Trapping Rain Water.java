// 6ms. 하드인데 한번에 풀어서 기분좋다. 생각해보니 어느 회사 공채에서 풀었던 문제와 동일하더라.
class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();

        int result = 0;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            int peek = stack.peekFirst();
            // peek 높이가 같거나 높은 경우
            if (height[peek] >= height[i]) {
                stack.push(i);
                continue;
            }

            // peek 높이가 낮은 경우
            if (height[peek] < height[i]) {
                while (height[peek] < height[i]) {
                    int popIndex = stack.pop();
                    // 뺐는데 이제 아무것도 없으면 스킵해야함
                    if (stack.isEmpty()) {
                        break;
                    }
                    peek = stack.peekFirst();
                    int wallHeight = height[i] >= height[peek] ? height[peek] : height[i];

                    int water = (wallHeight - height[popIndex]) * (i - peek - 1);
                    if (water > 0) {
                        result += water;
                    }
                }
                stack.push(i);
            }
        }

        return result;
    }
}
