package chapter6;

import java.util.ArrayList;

/**
 * 重载toString
 * @param <E>
 */
public class ArrayListToString<E> extends ArrayList<E> {

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < size(); i++) {
            str.append(get(i)).append(" ");
        }

        return str.toString();
    }

    public static void main(String[] args) {
        ArrayListToString<Integer> list = new ArrayListToString<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
    }

}