package chapter5;

/**
 * 汉诺塔
 */
public class Hannoi {

    public static void move(int n, char from, char buffer, char to) {
        if (n == 0)
            return;
        move(n - 1, from, to, buffer);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        move(n - 1, buffer, from, to);
    }


    public static void main(String[] args) {
        Hannoi.move(3, 'A', 'B', 'C');
    }

}
