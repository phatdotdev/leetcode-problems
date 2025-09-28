
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        helper(s, 0, dict, curr, res);
        return res;
    }

    private void helper(String s, int i, Set<String> dict, List<String> curr, List<String> res) {
        int n = s.length();
        if (i == n) {
            if (!curr.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < curr.size(); j++) {
                    if (j > 0)
                        sb.append(' ');
                    sb.append(curr.get(j));
                }
                res.add(sb.toString());
            }
            return;
        }
        for (int j = i + 1; j <= n; j++) {
            String word = s.substring(i, j);
            if (dict.contains(word)) {
                curr.add(word);
                helper(s, j, dict, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}

/*
 * public List<String> wordBreak(String s, List<String> wordDict) {
 * // HashSet - Min - Max
 * HashSet<String> dict = new HashSet<>(wordDict);
 * int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
 * for (String w : dict) {
 * minLen = Math.min(minLen, w.length());
 * maxLen = Math.max(maxLen, w.length());
 * }
 * // DP
 * int n = s.length();
 * List<String>[] dp = new List[n + 1];
 * dp[0] = new ArrayList<>();
 * dp[0].add("");
 * for (int i = 0; i <= n; i++) {
 * if (dp[i] == null)
 * continue;
 * for (int len = minLen; len <= maxLen; len++) {
 * String sub = s.substring(i, i + len);
 * if (dict.contains(sub)) {
 * if (dp[i + len] == null) {
 * dp[i + len] = new ArrayList<>();
 * }
 * for (String sentence : dp[i]) {
 * dp[i + len].add(sentence.isEmpty() ? sub : sentence + " " + sub);
 * }
 * }
 * }
 * }
 * return dp[n] == null ? new ArrayList<>() : dp[n];
 * }
 */

/*
 * public List<String> wordBreak(String s, List<String> wordDict) {
 * int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
 * HashSet<String> dict = new HashSet<>();
 * for (String word : wordDict) {
 * dict.add(word);
 * minLen = Math.min(minLen, word.length());
 * maxLen = Math.max(maxLen, word.length());
 * }
 * int n = s.length();
 * 
 * @SuppressWarnings("unchecked")
 * List<String>[] dp = new ArrayList[n + 1];
 * dp[0] = new ArrayList<>();
 * dp[0].add("");
 * for (int i = 0; i < n; i++) {
 * if (dp[i] == null)
 * continue;
 * for (int len = minLen; len <= maxLen && i + len <= n; len++) {
 * String sub = s.substring(i, i + len);
 * if (dict.contains(sub)) {
 * if (dp[i + len] == null)
 * dp[i + len] = new ArrayList<>();
 * for (String sentence : dp[i]) {
 * dp[i + len].add(sentence.isEmpty() ? sub : sentence + " " + sub);
 * }
 * }
 * }
 * }
 * 
 * return dp[n] == null ? new ArrayList<>() : dp[n];
 * }
 */