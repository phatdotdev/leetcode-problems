
public class RomanToInteger {
    public int romanToInt(String s) {
        int res = 0, curr = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            curr = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            if (prev > curr) {
                res -= curr;
            } else {
                res += curr;
            }
            prev = curr;
        }
        return res;
    }
}
