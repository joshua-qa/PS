// 1ms. 백준에 아주 비슷한 문제가 있어서 풀었던 기억이 난다. 근데 조건문이 너무 지저분함
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/


class Solution {
    public Node construct(int[][] grid) {
        return makeTree(grid, 0, grid.length-1, 0, grid[0].length-1);
    }

    private Node makeTree(int[][] grid, int startX, int endX, int startY, int endY) {
        if (endX - startX == 0 && endY - startY == 0) {
            return new Node(grid[startX][startY] == 1, true, null, null, null, null);
        }

        int size = endX - startX + 1;
        int half = size / 2;
        Node topLeft = makeTree(grid, startX, startX+half-1, startY, startY+half-1);
        Node topRight = makeTree(grid, startX, startX+half-1, endY-half+1, endY);
        Node bottomLeft = makeTree(grid, endX-half+1, endX, startY, startY+half-1);
        Node bottomRight = makeTree(grid, endX-half+1, endX, endY-half+1, endY);

        if ((topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) &&
                ((topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) ||
                (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val))) {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
