package chapter4;

import java.util.Arrays;

/**
 * 数组排序，考察调用API
 */
public class ArraySort {

    public static void main(String[] args) {
        int[] number = {70, 80, 31, 37, 10, 1, 48, 60, 33, 80};

        Arrays.sort(number);

        for (int val: number) {
            System.out.println(val);
        }
    }

}
