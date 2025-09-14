
public class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if (n == 1)
            return 9;

        int max = (int) Math.pow(10, n) - 1;
        int min = (int) Math.pow(10, n - 1);

        for (int half = max; half >= min; half--) {
            long p = makePalindrome(half);

            for (long a = max; a >= min; a--) {
                if (p / a > max)
                    break;
                if (p % a == 0) {
                    long b = p / a;
                    if (b >= min && b <= max) {
                        return (int) (p % 1337);
                    }
                }
            }
        }
        return -1;
    }

    private long makePalindrome(int half) {
        long full = half;
        int x = half;
        while (x > 0) {
            full = full * 10 + x % 10;
            x /= 10;
        }
        return full;
    }

}

/*
 * public int largestPalindrome(int n) {
 * if (n == 1)
 * return 9;
 * int max = (int) Math.pow(10, n) - 1;
 * int min = (int) Math.pow(10, n - 1);
 * for (int half = max; half >= min; half--) {
 * long p = palindrome(half);
 * for (long a = max; a >= min; a--) {
 * if (p / a > max)
 * break;
 * if (p % a == 0) {
 * long b = p / a;
 * if (b >= min && b <= max) {
 * return (int) (p % 1337);
 * }
 * }
 * }
 * }
 * return -1;
 * }
 * 
 * private long palindrome(int half) {
 * long full = half;
 * while (half > 0) {
 * full = full * 10 + half % 10;
 * half /= 10;
 * }
 * return full;
 * }
 */