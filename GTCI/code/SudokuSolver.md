# Sudoku Solver (hard)

## problem statement

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

## my solution (working, 30 minutes)

```java
/**
 * solve for a sudoku given a board
 * will there be at least a single valid output? yes
 * given the board, i will need to track rows, cols, boxes
 * this will indicate the numbers used in each row, col, and box
 * 2D matrix size of 10 for 1-indexing
 * prefill the rows, cols, boxes accordingly to current board
 * once done, you can start backtracking from tile 0,0
 * if current tile is already filled, you can work on the next tile
 * helper functions: incrementCount, decrementCount, nextBacktrack, backtrack
 * for each box: do a mapping of i,j such that
 *          idx of a box: (i / 3) * 3 + (j / 3)
 *          0, 1, 2
 *          3, 4, 5
 *          6, 7, 8
 */

class Solution {
    static final int N = 9; // board size
    int[][] rows;
    int[][] cols;
    int[][] boxes;
    char[][] board;
    boolean isSolved;
    public void solveSudoku(char[][] board) {
        rows = new int[N][10];
        cols = new int[N][10];
        boxes = new int[N][10];
        this.board = board;
        isSolved = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (this.board[i][j] != '.') {
                    int k = Character.getNumericValue(this.board[i][j]);
                    incrementCount(i, j, k);
                }
            }
        }

        backtrack(0,0);
    }

    private void backtrack(int i, int j) {
        if (this.board[i][j] != '.') {
            nextBacktrack(i, j);
            return;
        }
        int boxIdx = (i / 3) * 3 + (j / 3);
        for (int k = 1; k < 10; k++) {
            if (rows[i][k] + cols[j][k] + boxes[boxIdx][k] == 0) {
                incrementCount(i, j, k);
                this.board[i][j] = (char)(k + '0');
                nextBacktrack(i, j);
                if (!isSolved) {
                    this.board[i][j] = '.';
                    decrementCount(i, j, k);
                }
            }
        }
    }

    private void nextBacktrack(int i, int j) {
        if (i == 8 && j == 8) {
            this.isSolved = true;
            return;
        }
        if (j == 8) {
            backtrack(i + 1, 0);
        } else {
            backtrack(i, j + 1);
        }
    }

    private void incrementCount(int i, int j, int d) {
        int boxIdx = (i / 3) * 3 + (j / 3);
        boxes[boxIdx][d]++;
        rows[i][d]++;
        cols[j][d]++;
    }

    private void decrementCount(int i, int j, int d) {
        int boxIdx = (i / 3) * 3 + (j / 3);
        boxes[boxIdx][d]--;
        rows[i][d]--;
        cols[j][d]--;
    }
}
```
