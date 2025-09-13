public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();
        long base = 131;
        long mod = 1000000007;

        int best = -1;

        long forward = 0, backward = 0, power = 1;
        for (int i = 0; i < n; i++) {
            int value = s.charAt(i) - 'a' + 1;
            forward = (forward * base + value) % mod;
            backward = (backward + power * value) % mod;
            if (forward == backward) {
                best = 1;
            }
            power = (power * base) % mod;
        }
        String suffix = s.substring(best + 1);
        return new StringBuilder(suffix).reverse().toString() + s;
    }
}
