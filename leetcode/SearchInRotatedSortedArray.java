package Joshua.PS;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.run(in, out);
        out.close();
    }

    static class Task {
        public void run(InputReader in, PrintWriter out) {
            int[] nums = {3, 1};
            out.println(search(nums, 1));
            int[] nums2 = {1, 3};
            out.println(search(nums2, 3));
            int[] nums3 = {4, 5, 6, 7, 0, 1, 2};
            out.println(search(nums3, 0));
            out.println(search(nums3, 3));
        }

        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int start = 0;
            int left = 0;
            int length = nums.length;
            int right = length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                // mid가 length-1보다 크면 회전한 것으로 판별
                if (nums[mid] > nums[length-1]) {
                    start = Math.min(mid + 1, length - 1);
                    left = start;
                } else {
                    right = mid - 1;
                }
            }

            if (start == 0) {
                left = 0;
                right = length - 1;
            } else if (nums[start] == target) {
                return start;
            } else if (nums[length-1] < target) {
                left = 0;
                right = Math.max(start-1, 0);
            } else {
                left = Math.min(start+1, length-1);
                right = length - 1;
            }
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}