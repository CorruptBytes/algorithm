package com.example.y2026.m04.day9;
/**
 * <h1>建立四叉树</h1>
 * 
 */
public class P427 {

    public Node construct(int[][] grid) {
        int n = grid.length;
        return createNode(grid, 0, n, 0,n);
    }
    //前闭后开
    public Node createNode(int[][] grid,int rowStartIndex, 
        int rowEndIndex, int columnStartIndex, int columnEndIndex
    ) {
        if (rowEndIndex - rowStartIndex == 1) {
            return new Node(grid[rowStartIndex][columnStartIndex] == 1,true);
        }
        int target = grid[rowStartIndex][columnStartIndex];
        boolean isLeaf = true;
        for(int i = rowStartIndex; i < rowEndIndex; i++) {
            for(int j = columnStartIndex; j < columnEndIndex; j++) {
                if (grid[i][j] != target) {
                    isLeaf = false;
                    break;
                }
            }
            if (!isLeaf) {
                break;
            }
        }
        Node node = new Node();
        node.val = target == 1;
        node.isLeaf = isLeaf;
        if (!isLeaf) {
            int count = (rowEndIndex - rowStartIndex) / 2;
            node.topLeft = createNode(grid,rowStartIndex,rowStartIndex + count,columnStartIndex,columnStartIndex + count);
            node.topRight = createNode(grid,rowStartIndex,rowStartIndex + count,columnStartIndex + count,columnEndIndex);
            node.bottomLeft = createNode(grid,rowStartIndex + count,rowEndIndex,columnStartIndex,columnStartIndex + count);
            node.bottomRight = createNode(grid,rowStartIndex + count,rowEndIndex,columnStartIndex + count,columnEndIndex);
        }
        return node;
    }


}

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
}

