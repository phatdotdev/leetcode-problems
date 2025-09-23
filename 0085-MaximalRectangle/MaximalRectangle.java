public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] height = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int ans = 0;

        int currLeft = 0;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '0') {
                height[0][j] = 0;
                left[0][j] = 0;
                currLeft = j + 1;
            } else {
                height[0][j] = 1;
                left[0][j] = currLeft;
            }
        }
        int currRight = n;
        for (int j = n - 1; j >= 0; j--) {
            if (matrix[0][j] == '0') {
                right[0][j] = n;
                currRight = j;
            } else {
                right[0][j] = currRight;
            }
            ans = Math.max(ans, height[0][j] * (right[0][j] - left[0][j]));
        }

        for (int i = 1; i < m; i++) {
            currLeft = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                    left[i][j] = currLeft;
                    currLeft = j + 1;
                } else {
                    height[i][j] = height[i - 1][j] + 1;
                    left[i][j] = Math.max(currLeft, left[i - 1][j]);
                }
            }
            currRight = n;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    right[i][j] = n;
                    currRight = j;
                } else {
                    right[i][j] = Math.min(currRight, right[i - 1][j]);
                }
                ans = Math.max(ans, height[i][j] * (right[i][j] - left[i][j]));
            }
        }
        return ans;
    }
}
