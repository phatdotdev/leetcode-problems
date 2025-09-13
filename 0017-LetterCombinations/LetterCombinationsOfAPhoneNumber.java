
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        char[][] letters = {
                {},
                {},
                { 'a', 'b', 'c' },
                { 'd', 'e', 'f' },
                { 'g', 'h', 'i' },
                { 'j', 'k', 'l' },
                { 'm', 'n', 'o' },
                { 'p', 'q', 'r', 's' },
                { 't', 'u', 'v' },
                { 'w', 'x', 'y', 'z' }
        };
        int curr = 0;
        StringBuilder sb = new StringBuilder("");
        if (digits.length() > 0)
            combination(digits, curr, sb, res, letters);
        return res;
    }

    public static void combination(String digits, int curr, StringBuilder sb, List<String> res, char[][] letters) {
        if (curr == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < letters[digits.charAt(curr) - '0'].length; i++) {
            sb.append(letters[digits.charAt(curr) - '0'][i]);
            combination(digits, curr + 1, sb, res, letters);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
