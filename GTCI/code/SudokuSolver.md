# Sudoku Solver (hard)

## problem statement

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

## my solution (working, 1 hour and 7 minutes)

```java
/**
 * check row, col, subbox for each empty cell
 * track each row, col, subbox for existing numbers
 * create array of size 10 to indicate if the digit exist in the options
 * for each cell,
 *      for each number 1 through 9:
 *          check if num is avail in row, col, subbox
 *              if so, fill in the blank with num and do recurisive call on the next cell
 *              check if the board has been completed, if so return, else continue
 */

class Solution {
    int[][] rows = new int[9][10];
    int[][] cols = new int[9][10];
    int[][] subboxs = new int[9][10];
    boolean completed = false;
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int d = Character.getNumericValue(board[i][j]);
                    addNum(i, j, d);
                }
            }
        }

        backtrack(0, 0);
    }

    public void backtrack(int i, int j) {
        // check if the value is permanent or not
        if (board[i][j] != '.') {
            nextBacktrack(i, j);
        } else {
            int idx = (i / 3) * 3 + (j / 3);
            for (int k = 1; k < 10; k++) {
                if (rows[i][k] + cols[j][k] + subboxs[idx][k] == 0) {
                    addNum(i, j, k);
                    nextBacktrack(i, j);
                    if (!completed)
                        removeNum(i, j, k);
                }
            }
        }
    }

    public void nextBacktrack(int i, int j) {
        if (i == 8 && j == 8) {
            completed = true;
        } else {
            if (j == 8) {
                backtrack(i + 1, 0);
            } else {
                backtrack(i, j + 1);
            }
        }

    }

    private void addNum(int i, int j, int num) {
        int idx = (i / 3) * 3 + (j / 3);
        rows[i][num]++;
        cols[j][num]++;
        subboxs[idx][num]++;
        board[i][j] = Character.forDigit(num, 10);
    }

    private void removeNum(int i, int j, int num) {
        int idx = (i / 3) * 3 + (j / 3);
        rows[i][num]--;
        cols[j][num]--;
        subboxs[idx][num]--;
        board[i][j] = '.';
    }
}
```
