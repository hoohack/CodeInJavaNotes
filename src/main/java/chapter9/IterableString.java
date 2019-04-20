package chapter9;

import java.util.Iterator;

/**
 * 使用增强式for
 */
class IterableString implements Iterable<Character> {

    private String str;

    IterableString(String str) {
        this.str = str;
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            private int index = 0;
            public boolean hasNext() {return index < str.length();}
            public Character next() { return str.charAt(index++);    }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        IterableString is = new IterableString("Hello");

        for (Character c: is) {
            System.out.println(c);
        }
    }
}
