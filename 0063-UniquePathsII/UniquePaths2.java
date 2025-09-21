public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        int[][] grid = new int[m][n];
        for (int c = 0; c < n; c++) {
            if (obstacleGrid[0][c] == 1) {
                break;
            } else {
                grid[0][c] = 1;
            }
        }
        for (int r = 0; r < m; r++) {
            if (obstacleGrid[r][0] == 1) {
                break;
            } else {
                grid[r][0] = 1;
            }
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (obstacleGrid[r][c] == 1) {
                    grid[r][c] = 0;
                } else {
                    grid[r][c] = grid[r - 1][c] + grid[r][c - 1];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
