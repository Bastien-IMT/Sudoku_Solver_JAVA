package sudoku.solver;

public class SudokuSolver {

    private final int GRID_SIZE = 9;
    public int[][] grid;


    public SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    public void print() {
        for (int row = 0; row < this.GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("- - - + - - - + - - -");
            }

            for (int col = 0; col < this.GRID_SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }

                if (col != 8) {
                    System.out.print(this.grid[row][col] + " ");
                } else {
                    System.out.println(this.grid[row][col]);
                }
            }
        }
    }

    private boolean possible(int row, int col, int number) {
        for (int i = 0; i < this.GRID_SIZE; i++) {
            // check in row if number already here
            if (this.grid[row][i] == number && col != i) {
                return false;
            }
            // check in column number already here
            if (this.grid[i][col] == number && row != i) {
                return false;
            }
        }
        // check in square if number already here
        int row0 = row - row % 3;
        int col0 = col - col % 3;

        for (int i = row0; i < row0 + 3; i++) {
            for (int j = col0; j < col0 + 3; j++) {
                if (this.grid[i][j] == number && i != row && j != col) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] find_empty_cell() {
        for (int row = 0; row < this.GRID_SIZE; row++) {
            for (int col = 0; col < this.GRID_SIZE; col++) {
                if (this.grid[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    public boolean solve() {
        int[] find_row_col = this.find_empty_cell();
        int row, col;

        if (find_row_col != null) {
            row = find_row_col[0];
            col = find_row_col[1];
        } else {
            return true;
        }

        for (int number = 1; number <= this.GRID_SIZE; number++) {
            if (this.possible(row, col, number)) {
                this.grid[row][col] = number;

                if (this.solve()) {
                    return true;
                }
                this.grid[row][col] = 0;
            }
        }
        return false;
    }
}