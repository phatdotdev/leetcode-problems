
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        int n = val.length;
        for (int i = 0; i < n; i++) {
            while (num >= val[i]) {
                sb.append(roman[i]);
                num -= val[i];
            }
        }
        return sb.toString();
    }
}