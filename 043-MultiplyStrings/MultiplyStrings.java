
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                final int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                final int sum = multiply + pos[i + j + 1];
                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }
        }
        for (final int p : pos) {
            if (p > 0 || sb.length() > 0) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

/*
 * public String multiply(String num1, String num2) {
 * if (num1.equals("0") || num2.equals("0"))
 * return "0";
 * 
 * String[] multiplies = new String[10]; // cache kết quả nhân với 0..9
 * Arrays.fill(multiplies, "");
 * 
 * String result = "0";
 * int n = num2.length();
 * 
 * for (int i = n - 1; i >= 0; i--) {
 * char digit = num2.charAt(i);
 * 
 * // lấy từ cache hoặc tính mới
 * String partial = (!multiplies[digit - '0'].equals(""))
 * ? multiplies[digit - '0']
 * : (multiplies[digit - '0'] = multiplyChar(num1, digit));
 * 
 * // shift theo vị trí
 * StringBuilder shifted = new StringBuilder(partial);
 * for (int j = 0; j < n - 1 - i; j++) {
 * shifted.append('0');
 * }
 * 
 * result = plus(result, shifted.toString());
 * }
 * 
 * return result;
 * }
 * 
 * private String plus(String num1, String num2) {
 * if (num1.equals("0")) return num2;
 * if (num2.equals("0")) return num1;
 * 
 * StringBuilder sb = new StringBuilder();
 * int idx1 = num1.length() - 1, idx2 = num2.length() - 1, carry = 0;
 * 
 * while (idx1 >= 0 || idx2 >= 0 || carry > 0) {
 * int d1 = (idx1 >= 0) ? num1.charAt(idx1--) - '0' : 0;
 * int d2 = (idx2 >= 0) ? num2.charAt(idx2--) - '0' : 0;
 * int total = d1 + d2 + carry;
 * sb.append((char) (total % 10 + '0'));
 * carry = total / 10;
 * }
 * 
 * return sb.reverse().toString();
 * }
 * 
 * private String multiplyChar(String num1, char num2) {
 * if (num2 == '0') return "0";
 * 
 * StringBuilder sb = new StringBuilder();
 * int idx1 = num1.length() - 1, carry = 0;
 * int d2 = num2 - '0';
 * 
 * while (idx1 >= 0 || carry > 0) {
 * int d1 = (idx1 >= 0) ? num1.charAt(idx1--) - '0' : 0;
 * int total = d1 * d2 + carry;
 * sb.append((char) (total % 10 + '0'));
 * carry = total / 10;
 * }
 * 
 * return sb.reverse().toString();
 * }
 * 
 */