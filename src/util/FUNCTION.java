package util;

import core.Node;

import static util.Checker.check;

/**
 * Class FUNCTION
 */
public class FUNCTION
{

    /**
     * outputs the matrix on the cli
     * @param matrix for the matrix of the puzzle
     */
    public static void output(int[][] matrix) {
        for(int[] i : matrix) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * @param matrix for the matrix of the puzzle
     * @param index for the current index
     * @param value for the value
     * @return the new matrix with the value set at the index
     */
    public static int[][] addValue(int[][] matrix, int index, int value) {
        int lineLength = matrix.length;
        int realIndex = index % lineLength;
        if(realIndex == 0) realIndex = lineLength;
        int lines = (index-realIndex)/lineLength;
        matrix[lines][realIndex-1] = value;
        return matrix;
    }

    /**
     * @param matrix for the matrix of the puzzle
     * @return a copy of the matrix
     */
    private static int[][] copyMatrix(int[][] matrix) {
        int[][] m = new int[matrix.length][matrix.length];
        for(int i=0; i<matrix.length; i++) {
            System.arraycopy(matrix[i], 0, m[i], 0, matrix.length);
        }
        return m;
    }

    /**
     * @param matrix for the matrix of the puzzle
     * @return the next index to solve
     */
    public static int calculateIndex(int[][] matrix) {
        int index = (matrix.length*matrix.length)+1;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                if(matrix[i][j] == 0) {
                    index = (i*matrix.length)+(j)+1;
                    return index;
                }
            }
        }
        return index;
    }

    /**
     * @param matrix for the matrix of the puzzle
     * @param index for the current index
     */
    public static void solve(int[][] matrix, int index) {
        int[] options = check(matrix, index);
        if(options.length == 0) return;
        for(int i : options) {
            Node n = new Node(FUNCTION.copyMatrix(matrix), index, i);
            n.solve();
        }
    }
}
