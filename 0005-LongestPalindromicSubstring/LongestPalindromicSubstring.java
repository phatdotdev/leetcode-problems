import java.util.Arrays;

public class LongestPalindromicSubstring {
    public class Solution {
        public String longestPalindrome(String s) {
            // Chuẩn hóa chuỗi
            String t = "^#" + String.join("#", s.split("")) + "#$";
            int n = t.length();
            int[] P = new int[n];
            Arrays.fill(P, 0);

            int center = 0, right = 0;

            for(int i = 1; i < n - 1; i++){
                int mirror = 2 * center - i;

                if(i < right){
                    P[i] = Math.min(right - i, P[mirror]);
                }

                // Mở rộng quanh i
                while(i - 1 - P[i] >= 0 && i + 1 + P[i] < n && t.charAt(i - 1 - P[i]) == t.charAt(i + 1 + P[i])){
                    P[i]++;
                }

                // Cập nhật center và right nếu mở rộng xa hơn
                if(i + P[i] > right){
                    center = i;
                    right = i + P[i];
                }
            }

            // Tìm palindrome dài nhất
            int maxLength = 0, centerIndex = 0;
            for(int i = 1; i < n - 1; i++){
                if(P[i] > maxLength){
                    maxLength = P[i];
                    centerIndex = i;
                }
            }

            int start = (centerIndex - maxLength) / 2;
            return s.substring(start, start + maxLength);
        }
    }
}
