
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        String[] templates = new String[n];
        for (int col = 0; col < n; col++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[col] = 'Q';
            templates[col] = new String(row);
        }
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        int[] queens = new int[n];
        backtrack(templates, cols, diag1, diag2, queens, 0, solutions);
        return solutions;
    }

    private void backtrack(
            String[] templates,
            boolean[] cols,
            boolean[] diag1,
            boolean[] diag2,
            int[] queens,
            int currentRow,
            List<List<String>> solutions) {
        int n = templates.length;
        if (currentRow == n) {
            List<String> board = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                board.add(templates[queens[row]]);
            }
            solutions.add(board);
        } else {
            for (int col = 0; col < n; col++) {
                if (!cols[col] && !diag1[currentRow - col + n - 1] && !diag2[currentRow + col]) {
                    cols[col] = true;
                    diag1[currentRow - col + n - 1] = true;
                    diag2[currentRow + col] = true;
                    queens[currentRow] = col;
                    backtrack(templates, cols, diag1, diag2, queens, currentRow + 1, solutions);
                    queens[currentRow] = -1;
                    cols[col] = false;
                    diag1[currentRow - col + n - 1] = false;
                    diag2[currentRow + col] = false;
                }
            }
        }
    }
}

/*
 * public List<List<String>> solveNQueens(int n) {
 * boolean[] cols = new boolean[n];
 * boolean[] diag1 = new boolean[2 * n - 1]; // row - col + n - 1
 * boolean[] diag2 = new boolean[2 * n - 1]; // row + col
 * int[] queens = new int[n];
 * List<List<String>> solutions = new ArrayList<>();
 * backtrack(cols, diag1, diag2, queens, 0, solutions);
 * return solutions;
 * }
 * 
 * private void backtrack(boolean[] cols, boolean[] diag1, boolean[] diag2,
 * int[] queens,
 * int currentRow,
 * List<List<String>> solutions) {
 * int n = cols.length;
 * if (currentRow == n) {
 * List<String> board = new ArrayList<>();
 * for (int row = 0; row < n; row++) {
 * StringBuilder strRow = new StringBuilder(".".repeat(n));
 * strRow.setCharAt(queens[row], 'Q');
 * board.add(strRow.toString());
 * }
 * solutions.add(board);
 * } else {
 * for (int col = 0; col < n; col++) {
 * if (!cols[col] && !diag1[currentRow - col + n - 1] && !diag2[currentRow +
 * col]) {
 * cols[col] = true;
 * diag1[currentRow - col + n - 1] = true;
 * diag2[currentRow + col] = true;
 * queens[currentRow] = col;
 * backtrack(cols, diag1, diag2, queens, currentRow + 1, solutions);
 * cols[col] = false;
 * diag1[currentRow - col + n - 1] = false;
 * diag2[currentRow + col] = false;
 * queens[currentRow] = -1;
 * }
 * }
 * }
 * }
 */

/*
 * public List<List<String>> solveNQueens(int n) {
 * List<List<String>> solutions = new ArrayList<>();
 * int[] queensPositions = new int[n];
 * Arrays.fill(queensPositions, -1);
 * backtrack(queensPositions, 0, solutions);
 * return solutions;
 * }
 * 
 * private void backtrack(int[] queenPositions, int currentRow,
 * List<List<String>> solutions) {
 * int n = queenPositions.length;
 * if (currentRow == n) {
 * List<String> board = new ArrayList<>();
 * for (int row = 0; row < currentRow; row++) {
 * StringBuilder rowString = new StringBuilder(".".repeat(n));
 * rowString.setCharAt(queenPositions[row], 'Q');
 * board.add(rowString.toString());
 * }
 * solutions.add(board);
 * } else {
 * for (int col = 0; col < n; col++) {
 * if (!isSafe(queenPositions, currentRow, col))
 * continue;
 * queenPositions[currentRow] = col;
 * backtrack(queenPositions, currentRow + 1, solutions);
 * queenPositions[currentRow] = -1;
 * }
 * }
 * }
 * 
 * private boolean isSafe(int[] queenPositions, int row, int col) {
 * for (int r = 0; r < row; r++) {
 * int c = queenPositions[r];
 * if (c == col)
 * return false;
 * if (Math.abs(col - c) == Math.abs(row - r))
 * return false;
 * }
 * return true;
 * }
 */