
public class NQueens2 {

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        return backtrack(cols, diag1, diag2, 0);
    }

    public int backtrack(boolean[] cols, boolean[] diag1, boolean[] diag2, int currentRow) {
        int n = cols.length;
        if (currentRow == n) {
            return 1;
        } else {
            int total = 0;
            for (int col = 0; col < n; col++) {
                int d1 = currentRow - col + n - 1, d2 = currentRow + col;
                if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                    cols[col] = true;
                    diag1[d1] = true;
                    diag2[d2] = true;
                    total += backtrack(cols, diag1, diag2, currentRow + 1);
                    cols[col] = false;
                    diag1[d1] = false;
                    diag2[d2] = false;
                }
            }
            return total;
        }
    }
}
