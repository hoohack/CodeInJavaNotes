package chapter4;

/**
 * 查找数字
 */
public class FindVal {

    static int[] number = {1, 10, 31, 33, 37, 48, 60, 70, 80};

    private static int findVal(int val) {
        for (int i = 0; i < FindVal.number.length; i++) {
            if (val == FindVal.number[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int val1 = 991;

        int val2 = 31;

        System.out.println(findVal(val1));

        System.out.println(findVal(val2));
    }

}
