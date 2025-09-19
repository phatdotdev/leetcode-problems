public class ValidNumber {
    public boolean isNumber(String s) {
        int n = s.length();
        boolean seenDigit = false;
        boolean seenExp = false;
        boolean seenDot = false;
        boolean seenDigitAfterExp = true;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                seenDigit = true;
                seenDigitAfterExp = true;
            } else if (c == '+' && c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } else if (c == '.') {
                if (seenDot || seenExp)
                    return false;
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                if (seenExp || !seenDigit)
                    return false;
                seenExp = true;
                seenDigitAfterExp = false;
            } else {
                return false;
            }
        }
        return seenDigit && seenDigitAfterExp;
    }
}

/*
 * public boolean isNumber(String s) {
 * int n = s.length();
 * boolean seenDigit = false;
 * boolean seenDot = false;
 * boolean seenExp = false;
 * boolean seenDigitAfterExp = true;
 * for (int i = 0; i < n; i++) {
 * char c = s.charAt(i);
 * if (c == '+' || c == '-') {
 * if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
 * return false;
 * } else if (Character.isDigit(c)) {
 * seenDigit = true;
 * seenDigitAfterExp = true;
 * } else if (c == 'e' || c == 'E') {
 * if (seenExp || !seenDigit)
 * return false;
 * seenExp = true;
 * seenDigitAfterExp = false;
 * } else if (c == '.') {
 * if (seenDot || seenExp)
 * return false;
 * seenDot = true;
 * } else {
 * return false;
 * }
 * }
 * return seenDigit && seenDigitAfterExp;
 * }
 */