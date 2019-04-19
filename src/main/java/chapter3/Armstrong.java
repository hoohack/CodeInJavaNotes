package chapter3;

/**
 * 阿姆斯特朗数
 */
public class Armstrong {

    private static boolean satisfyCondition(int val, int hundredPos, int tenPos, int digitPos) {
        return val == (Math.pow(hundredPos, 3) + Math.pow(tenPos, 3) + Math.pow(digitPos, 3));
    }

    public static void main(String[] args) {

        for (int start = 100; start < 1000; start++) {
            if (satisfyCondition(start, start/100, (start%100) / 10, start %10)) {
                System.out.println(start);
            }
        }

    }

}
