public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(tree));

        TreeNode nullNode = null;
        System.out.println(diameterOfBinaryTree(nullNode));
    }

    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxDiameter(root);
        return result;
    }

    private int getMaxDiameter(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftSize = (root.left != null) ? getMaxDiameter(root.left) : 0;
        int rightSize = (root.right != null) ? getMaxDiameter(root.right) : 0;
        if (leftSize + rightSize > result) {
            result = leftSize + rightSize;
        }
        return leftSize > rightSize ? leftSize + 1 : rightSize + 1;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
