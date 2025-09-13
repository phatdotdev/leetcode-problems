public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int open = 0, close = 0;
        /* Bo qua cac chuoi du ( o phia dau */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                open++;
            else
                close++;
            if (open == close) {
                maxLength = maxLength > 2 * close ? maxLength : 2 * close;
            } else if (open < close)
                close = open = 0;
        }
        /* Bo qua cac chuoi du ) o phia sau */
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                open++;
            else
                close++;
            if (close == open) {
                maxLength = maxLength > 2 * open ? maxLength : 2 * open;
            } else if (open > close)
                close = open = 0;
        }
        /* Ket hop 2 vong lap ta duoc ket qua chinh xac */
        return maxLength;
    }
}
