public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        if (s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int prev = (int) (s.charAt(i - 1) - '0');
            int curr = (int) (s.charAt(i) - '0');
            if (curr == 0) {
                if (prev == 1 || prev == 2) {
                    dp[i] = (i >= 2 ? dp[i - 2] : 1);
                } else {
                    return 0;
                }
            } else {
                dp[i] = dp[i - 1];
                int two = prev * 10 + curr;
                if (two >= 10 && two <= 26) {
                    dp[i] += (i >= 2 ? dp[i - 2] : 1);
                }
            }
        }
        return dp[n - 1];
    }
}