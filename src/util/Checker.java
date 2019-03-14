package util;

import java.util.ArrayList;

/**
 * Class Checker
 */
class Checker {

    /**
     * @param matrix for the matrix of the puzzle
     * @param index for the current index
     * @return an array of values, which are possible for this index vertically
     */
    private static int[] checkVertically(int[][] matrix, int index) {
        int lineLength = matrix.length;
        int realIndex = index % lineLength;
        if(realIndex == 0) realIndex = lineLength;
        ArrayList<Integer> available = new ArrayList<>();
        for(int[] a : matrix)
        {
            if(a[realIndex-1] != 0)
                available.add(a[realIndex-1]);
        }
        return adjustment(available, lineLength);
    }

    /**
     * @param matrix for the matrix of the puzzle
     * @param index for the current index
     * @return an array of values, which are possible for this index horizontally
     */
    private static int[] checkHorizontally(int[][] matrix, int index) {
        int lineLength = matrix.length;
        int realIndex = index % lineLength;
        if(realIndex == 0) realIndex = lineLength;
        int lines = (index-realIndex)/lineLength;
        ArrayList<Integer> available = new ArrayList<>();
        for(int i=0; i<lineLength; i++) {
            if(matrix[lines][i] != 0) {
                available.add(matrix[lines][i]);
            }
        }
        return adjustment(available, lineLength);
    }

    /**
     * @param matrix for the matrix of the puzzle
     * @param index for the current index
     * @return an array of values, which are possible for this index in the square
     */
    private static int[] checkSquare(int[][] matrix, int index) {
        int lineLength = matrix.length;
        int squareLength = (int) Math.sqrt(lineLength);
        int realIndex = index % lineLength;
        if(realIndex == 0) realIndex = lineLength;
        int lines = (index-realIndex)/lineLength;

        int yHelp = (lines+1) % squareLength;
        if(yHelp == 0) yHelp = squareLength;
        int ySquare = (((lines+1)-yHelp)/squareLength);

        int xHelp;
        if(squareLength > realIndex) xHelp = squareLength % realIndex;
        else xHelp = realIndex % squareLength;
        if(xHelp == 0) xHelp = squareLength;
        int xSquare = ((realIndex-xHelp)/squareLength);

        int xStart = squareLength*xSquare;
        int yStart = squareLength*ySquare;

        ArrayList<Integer> available = new ArrayList<>();
        for(int j=yStart; j<yStart+squareLength; j++) {
            for(int i=xStart; i<xStart+squareLength; i++) {
                if(matrix[j][i] != 0) {
                    available.add(matrix[j][i]);
                }
            }
        }
        return adjustment(available, lineLength);
    }

    /**
     * @param matrix for the matrix of the puzzle
     * @param index for the current index
     * @return an array of values, which are possible for this index
     */
    static int[] check(int[][] matrix, int index) {
        int[] arr1 = checkVertically(matrix, index);
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i : arr1) list1.add(i);
        int[] arr2 = checkHorizontally(matrix, index);
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i : arr2) list2.add(i);
        int[] arr3 = checkSquare(matrix, index);
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i : arr3) list3.add(i);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i : list1) {
            if(list2.contains(i) && list3.contains(i)) {
                list.add(i);
            }
        }
        return toArray(list);
    }

    /**
     * @param list an ArrayList
     * @return an array
     */
    private static int[] toArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * @param available a list of possible values for a index
     * @param lineLength the length of the matrix
     * @return an array of possibilities
     */
    private static int[] adjustment(ArrayList<Integer> available, int lineLength) {
        ArrayList<Integer> expected = new ArrayList<>();
        for(int i=1; i<=lineLength; i++) {
            expected.add(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : expected) {
            if(!available.contains(i)) {
                list.add(i);
            }
        }
        return toArray(list);
    }
}
