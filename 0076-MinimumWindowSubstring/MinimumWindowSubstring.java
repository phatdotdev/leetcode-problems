
import java.util.Arrays;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int[] need = new int[128];
        Arrays.fill(need, 0);
        for (char c : t.toCharArray()) {
            need[c] += 1;
        }
        int required = 0;
        for (int i = 0; i < 128; i++) {
            if (need[i] > 0)
                required++;
        }
        int start = 0, left = 0, right = 0, valid = 0, minLength = Integer.MAX_VALUE;
        int[] window = new int[128];
        Arrays.fill(window, 0);
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
                while (valid == required) {
                    if (minLength > right - left) {
                        minLength = right - left;
                        start = left;
                    }
                    char d = s.charAt(left++);
                    if (need[d] > 0) {
                        if (window[d] == need[d])
                            valid--;
                        window[d]--;
                    }
                }
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
