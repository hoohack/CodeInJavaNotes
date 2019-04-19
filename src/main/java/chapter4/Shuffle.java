package chapter4;

import java.util.Random;

/**
 * 扑克牌洗牌程序
 */
public class Shuffle {

    private static void work() {
        String[] kind = {"桃", "砖", "梅", "心"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] cardFlag = new int[52];

        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int randNum = rand.nextInt(52);
            while (cardFlag[randNum] == 1) {
                randNum = rand.nextInt(52);
            }
            cardFlag[randNum] = 1;

            System.out.print(kind[randNum / 13] + " ");
            System.out.print(numbers[randNum % 13] + " ");
            if ((i+1) % 13 == 0) {
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        work();
    }

}
