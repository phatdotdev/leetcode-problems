
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
        HashSet<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            if (!dp[i])
                continue;
            for (int len = minLen; len <= maxLen && len + i <= n; len++) {
                if (dict.contains(s.substring(i, i + len))) {
                    dp[i + len] = true;
                }
            }
        }
        return dp[n];
    }
}

/*
 * TIME LIMIT EXCEEDED
 * public boolean wordBreak(String s, List<String> wordDict) {
 * Set<String> dict = new HashSet<>();
 * for (String word : wordDict) {
 * dict.add(word);
 * }
 * int n = s.length();
 * Stack<Integer> stack = new Stack<>();
 * stack.push(-1);
 * StringBuilder sb = new StringBuilder();
 * while (!stack.isEmpty()) {
 * sb.setLength(0);
 * int i = stack.pop() + 1;
 * for (; i < n; i++) {
 * sb.append(s.charAt(i));
 * if (dict.contains(sb.toString())) {
 * if (i == n - 1)
 * return true;
 * stack.push(i);
 * }
 * }
 * }
 * return false;
 * }
 */