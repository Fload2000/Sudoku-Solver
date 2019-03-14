package core;

import main.Main;
import util.FUNCTION;

import static util.FUNCTION.*;

/**
 * Class Node
 */
public class Node {

    /**
     * Variable for the index
     */
    private int index;

    /**
     * Variable for the matrix
     */
    private int[][] matrix;

    /**
     * Constructor of the Node class
     * @param matrix for the matrix of the puzzle
     * @param index for the current index
     * @param value fot the current value
     */
    public Node(int[][] matrix, int index, int value)
    {
        this.matrix = addValue(matrix, index, value);
        this.index = index;
    }

    /**
     * solves the puzzle recursive
     */
    public void solve() {
        if(index > matrix.length*matrix.length || calculateIndex(matrix) > matrix.length*matrix.length) {
            long timeEnd = System.currentTimeMillis();
            output(matrix);
            System.out.println("Runtime: " + (timeEnd - Main.timeStart) + " ms");
            System.exit(1);
        }

        index = calculateIndex(matrix);

        FUNCTION.solve(matrix, index);
    }
}
