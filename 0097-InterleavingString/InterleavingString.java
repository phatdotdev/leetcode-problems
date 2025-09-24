
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length())
            return false;
        if (n == 0)
            return s1.equals(s3);
        if (m == 0)
            return s2.equals(s3);
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }
}

/*
 * public boolean isInterleave(String s1, String s2, String s3) {
 * if (s1.length() + s2.length() != s3.length())
 * return false;
 * return isInterleave(s1, s2, s3, 0, 0);
 * }
 * 
 * public boolean isInterleave(String s1, String s2, String s3, int i, int j) {
 * if (i + j == s3.length())
 * return true;
 * if (i < s1.length()) {
 * if (s1.charAt(i) == s3.charAt(i + j)) {
 * if (isInterleave(s1, s2, s3, i + 1, j)) {
 * return true;
 * }
 * }
 * }
 * if (j < s2.length()) {
 * if (s2.charAt(j) == s3.charAt(i + j)) {
 * if (isInterleave(s1, s2, s3, i, j + 1)) {
 * return true;
 * }
 * }
 * }
 * return false;
 * }
 */