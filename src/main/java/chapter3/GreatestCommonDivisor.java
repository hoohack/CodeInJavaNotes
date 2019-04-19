package chapter3;

/**
 * 最大公约数
 */
public class GreatestCommonDivisor {

    private static int gcd(int m, int n) {
        if (0 == n) return m;
        return gcd(n, m%n);
    }

    public static void main(String[] args) {
        int m = 1000;
        int n = 495;

        int result = gcd(m, n);

        System.out.println(result);
    }

}
