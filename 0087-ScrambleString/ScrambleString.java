
import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (s1.length() != s2.length()) {
            memo.put(key, false);
            return false;
        }
        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }
        int n = s1.length();
        if (!hasSameChars(s1, s2)) {
            memo.put(key, false);
            return false;
        }
        for (int len = 1; len < n; len++) {
            if (isScramble(s1.substring(0, len), s2.substring(0, len))
                    && isScramble(s1.substring(len, n), s2.substring(len, n))
                    || isScramble(s1.substring(0, len), s2.substring(n - len, n))
                            && isScramble(s1.substring(len, n), s2.substring(0, n - len))) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }

    private boolean hasSameChars(String a, String b) {
        int[] count = new int[26];
        for (char c : a.toCharArray())
            count[c - 'a']++;
        for (char c : b.toCharArray())
            count[c - 'a']--;
        for (int x : count)
            if (x != 0)
                return false;
        return true;
    }
}

/*
 * public boolean isScramble(String s1, String s2) {
 * if (s1.length() != s2.length())
 * return false;
 * if (s1.equals(s2))
 * return true;
 * int n = s1.length();
 * boolean[][][] dp = new boolean[n][n][n + 1];
 * for (int i = 0; i < n; i++) {
 * for (int j = 0; j < n; j++) {
 * dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
 * }
 * }
 * for (int len = 2; len <= n; len++) {
 * for (int i = 0; i + len <= n; i++) {
 * for (int j = 0; j + len <= n; j++) {
 * for (int k = 1; k < len; k++) {
 * if (dp[i][j][k] && dp[i + k][j + k][len - k] ||
 * dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
 * dp[i][j][len] = true;
 * break;
 * }
 * }
 * }
 * }
 * }
 * return dp[0][0][n];
 * }
 */