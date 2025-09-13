public class PalindromeNumber {
     public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        int original = x, reveresed = 0;
        while(x > 0){
            reveresed = reveresed * 10 + x % 10;
            x /= 10;
        }
        return original == reveresed;
    }
}
