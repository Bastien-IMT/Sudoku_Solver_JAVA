package sudoku.solver;

import java.util.ArrayList;

public class Main {

    public static int[][] grid1 = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
    };

    public static int[][] grid2 = {
            {7, 8, 0, 4, 0, 0, 1, 2, 0},
            {6, 0, 0, 0, 7, 5, 0, 0, 9},
            {0, 0, 0, 6, 0, 1, 0, 7, 8},
            {0, 0, 7, 0, 4, 0, 2, 6, 0},
            {0, 0, 1, 0, 5, 0, 9, 3, 0},
            {9, 0, 4, 0, 6, 0, 0, 0, 5},
            {0, 7, 0, 3, 0, 0, 0, 1, 2},
            {1, 2, 0, 0, 0, 7, 4, 0, 0},
            {0, 4, 9, 2, 0, 6, 0, 0, 7}

    };

    public static ArrayList<int[][]> grids = new ArrayList<>();


    public static void main(String[] args) {

        grids.add(grid1);
        grids.add(grid2);

        for (int[][] grid : grids){

            System.out.println("\nOriginal grid: ");

            SudokuSolver solver = new SudokuSolver(grid);
            solver.print();

            System.out.println("\nSolved :");

            long startTime = System.nanoTime();
            solver.solve();

            long elapsedTime = (System.nanoTime() - startTime) /1000000;

            solver.print();
            System.out.println("Time to compute (ms): " + elapsedTime);

        }
    }

}
