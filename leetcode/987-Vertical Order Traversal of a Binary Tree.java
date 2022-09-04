// 3ms. 조건 하나 추가된거 때문에 복잡해진 문제. 하드까진 아닌듯..
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Node>> nodes = new TreeMap<>();

        Queue<Node> nodeQueue = new LinkedList<>();

        nodeQueue.offer(new Node(0, 0, root));
        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();

            int row = currNode.row;
            int column = currNode.column;
            if (!nodes.containsKey(column)) {
                List<Node> columnValues = new ArrayList<>();
                columnValues.add(currNode);
                nodes.put(column, columnValues);
            } else {
                nodes.get(column).add(currNode);
            }

            if (currNode.node.left != null) {
                nodeQueue.offer(new Node(row + 1, column - 1, currNode.node.left));
            }
            if (currNode.node.right != null) {
                nodeQueue.offer(new Node(row + 1, column + 1, currNode.node.right));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int key : nodes.keySet()) {
            List<Node> currList = nodes.get(key);
            Collections.sort(currList);
            List<Integer> nums = new ArrayList<>();
            for (Node node : currList) {
                nums.add(node.node.val);
            }
            result.add(nums);
        }
        return result;
    }

    class Node implements Comparable<Node> {
        int row;
        int column;
        TreeNode node;

        public Node(int row, int column, TreeNode node) {
            this.row = row;
            this.column = column;
            this.node = node;
        }

        @Override
        public int compareTo(Node o) {
            if (o.row == this.row && o.column == this.column) {
                return this.node.val - o.node.val;
            }
            return this.row - o.row;
        }
    }
}
