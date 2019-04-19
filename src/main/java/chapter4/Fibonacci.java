package chapter4;

/**
 * 斐波那契数列
 */
public class Fibonacci {

    private static int run(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }

        return run(num -1) + run(num - 2);
    }

    public static void main(String[] args) {
        int result = run(9);
        System.out.println(result);
    }

}
