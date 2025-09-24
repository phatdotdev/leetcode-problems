
import java.util.Arrays;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int left = 0; left < n; left++) {
                int right = i - left - 1;
                dp[i] += (dp[left] * dp[right]);
            }
        }
        return dp[n];
    }
}
