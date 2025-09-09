
import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 3)
            return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += 2 * i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 1; // tính số 2
        for (int i = 3; i < n; i += 2) {
            if (isPrime[i])
                count++;
        }
        return count;
    }
}
