public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstColZero = false, firstRowZero = false;

        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (firstColZero) {
            for (int r = 0; r < m; r++) {
                matrix[r][0] = 0;
            }
        }

        if (firstRowZero) {
            for (int c = 0; c < n; c++) {
                matrix[0][c] = 0;
            }
        }

    }
}

/*
 * public void setZeroes(int[][] matrix) {
 * int n = matrix.length, m = matrix[0].length;
 * boolean[] cols = new boolean[m];
 * boolean[] rows = new boolean[n];
 * for (int r = 0; r < n; r++) {
 * for (int c = 0; c < m; c++) {
 * if (matrix[r][c] == 0) {
 * cols[c] = true;
 * rows[r] = true;
 * }
 * }
 * }
 * for (int r = 0; r < n; r++) {
 * for (int c = 0; c < m; c++) {
 * if (cols[c] || rows[r]) {
 * matrix[r][c] = 0;
 * }
 * }
 * }
 * }
 */