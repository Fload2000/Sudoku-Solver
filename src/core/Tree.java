package core;

import util.FUNCTION;

/**
 * Class Tree
 */
public class Tree {

    /**
     * Variable for the matrix
     */
    private int[][] matrix;

    /**
     * Variable for the index
     */
    private int index;

    /**
     * Constructor for the Tree class
     * @param matrix the matrix of the puzzle
     */
    public Tree(int[][] matrix) {
        this.matrix = matrix;
        calculateIndex();
    }

    /**
     * solves the puzzle
     */
    public void solve() {
        FUNCTION.solve(matrix, index);
        System.out.println("Not a valid matrix");
    }

    /**
     * calculates the index to start solving
     */
    private void calculateIndex() {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                if(matrix[i][j] == 0) {
                    index = (i*matrix.length)+(j+1);
                    return;
                }
            }
        }
    }
}
