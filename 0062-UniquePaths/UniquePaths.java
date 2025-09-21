
import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        int[] curr = new int[n];
        Arrays.fill(prev, 1);
        curr[0] = 1;
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                curr[c] = curr[c - 1] + prev[c];
                prev[c] = curr[c];
            }
        }
        return curr[n - 1];
    }
}
/*
 * public int uniquePaths(int m, int n) {
 * int[][] grid = new int[m][n];
 * for (int r = 0; r < m; r++) {
 * grid[r][0] = 1;
 * }
 * for (int c = 0; c < n; c++) {
 * grid[0][c] = 1;
 * }
 * for (int r = 1; r < m; r++) {
 * for (int c = 1; c < n; c++) {
 * grid[r][c] = grid[r - 1][c] + grid[r][c - 1];
 * }
 * }
 * return grid[m - 1][n - 1];
 * }
 */