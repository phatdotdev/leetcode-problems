
public class SudokuSolve {

    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if (i == 9)
            return true;
        else if (j == 9)
            return solve(board, i + 1, 0);
        else if (board[i][j] != '.') {
            return solve(board, i, j + 1);
        } else {
            for (char num = 1; num <= 9; num++) {
                int boxInx = (i / 3) * 3 + j / 3;
                if (!rows[i][num] && !cols[j][num] && !boxes[boxInx][num]) {
                    board[i][j] = (char) (num + '0');
                    rows[i][num] = cols[j][num] = boxes[boxInx][num] = true;
                    if (solve(board, i, j + 1))
                        return true;
                    board[i][j] = '.';
                    rows[i][num] = cols[j][num] = boxes[boxInx][num] = false;
                }
            }
            return false;
        }
    }
}

/*
 * private boolean isValid(char[][] board, int i, int j, char num) {
 * for (int r = 0; r < 9; r++) {
 * if (board[r][j] == num)
 * return false;
 * }
 * for (int c = 0; c < 9; c++) {
 * if (board[i][c] == num)
 * return false;
 * }
 * int row = i / 3 * 3;
 * int col = j / 3 * 3;
 * for (int r = row; r < row + 3; r++) {
 * for (int c = col; c < col + 3; c++) {
 * if (board[r][c] == num)
 * return false;
 * }
 * }
 * return true;
 * }
 */