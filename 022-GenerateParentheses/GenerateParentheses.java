import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int open = 0, close = 0;
        backtracking(n, open, close, sb, ls);
        return ls;
    }

    private static void backtracking(int n, int open, int close, StringBuilder sb, List<String> ls) {
        if (close == n) {
            ls.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtracking(n, open + 1, close, sb, ls);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtracking(n, open, close + 1, sb, ls);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
