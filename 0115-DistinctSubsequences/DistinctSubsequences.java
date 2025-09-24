
import java.util.Arrays;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= m; i++) {
            char c = t.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (c == s.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
