public class Pow {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    public double fastPow(double x, int n) {
        if (n == 0)
            return 1;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
