package chapter6;

import java.util.ArrayList;

/**
 * 重载equals
 */
public class ArrayListEquals extends ArrayList {

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof ArrayList) && this.size() != ((ArrayList) o).size()) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (!get(i).equals(((ArrayList) o).get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();

        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        if (list1.equals(list2)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

        list1.clear();
        list2.clear();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(2);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        if (list1.equals(list2)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

    }


}