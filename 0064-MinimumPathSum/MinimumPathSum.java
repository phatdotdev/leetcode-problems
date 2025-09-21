
import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(m - 1, n - 1, grid, dp);
    }

    private int helper(int r, int c, int[][] grid, int[][] dp) {
        if (r == 0 && c == 0)
            return grid[0][0];
        if (r < 0 || c < 0)
            return Integer.MAX_VALUE;
        if (dp[r][c] != -1)
            return dp[r][c];
        int upRes = helper(r - 1, c, grid, dp);
        int leftRes = helper(r, c - 1, grid, dp);

        int up = (upRes == Integer.MAX_VALUE) ? Integer.MAX_VALUE : upRes + grid[r][c];
        int left = (leftRes == Integer.MAX_VALUE) ? Integer.MAX_VALUE : leftRes + grid[r][c];

        return dp[r][c] = Math.min(up, left);
    }
}

/*
 * public int minPathSum(int[][] grid) {
 * int m = grid.length, n = grid[0].length;
 * int[][] sum = new int[m][n];
 * sum[0][0] = grid[0][0];
 * for (int r = 1; r < m; r++) {
 * sum[r][0] = sum[r - 1][0] + grid[r][0];
 * }
 * for (int c = 1; c < n; c++) {
 * sum[0][c] = sum[0][c - 1] + grid[0][c];
 * }
 * for (int r = 1; r < m; r++) {
 * for (int c = 1; c < n; c++) {
 * sum[r][c] = Math.min(sum[r][c - 1], sum[r - 1][c]) + grid[r][c];
 * }
 * }
 * return sum[m - 1][n - 1];
 * }
 */