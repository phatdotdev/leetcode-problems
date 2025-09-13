
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, starIdx = -1, match = 0;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIdx = j;
                match = i;
                j++;
            } else if (starIdx != -1) {
                j = starIdx + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}
/*
 * public boolean isMatch(String s, String p) {
 * int i = 0, j = 0;
 * return greedy(i, j, s, p);
 * }
 * 
 * private static boolean greedy(int i, int j, String s, String p) {
 * if (i == s.length() && j == p.length())
 * return true;
 * else if (j == p.length() && i < s.length())
 * return false;
 * else if (i == s.length()) {
 * for (int l = j; l < p.length(); l++) {
 * if (p.charAt(l) != '*')
 * return false;
 * }
 * return true;
 * } else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
 * return greedy(i + 1, j + 1, s, p);
 * } else if (p.charAt(j) == '*') {
 * if (j == p.length() - 1)
 * return true;
 * while (i < s.length()) {
 * boolean isTrue = greedy(i, j + 1, s, p);
 * if (isTrue)
 * return true;
 * i++;
 * }
 * return false;
 * }
 * return false;
 * }
 */