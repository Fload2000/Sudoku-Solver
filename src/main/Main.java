package main;

import core.Tree;

import static test.Test.*;

/**
 * Class Main
 */
public class Main {

    /**
     * Variable for the time the algorithms starts to solve the puzzle
     */
    public static long timeStart = 0;

    /**
     * @param args start flags
     */
    public static void main(String[] args) {
        Tree tree = new Tree(matrix);
        timeStart = System.currentTimeMillis();
        System.out.println();
        tree.solve();
    }
}
