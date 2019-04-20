package chapter12;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.out;

/**
 * 增加lambda方法
 * @param <E>
 */
public class ArrayList<E> {

    private Object[] elems;

    private int next;

    public ArrayList(int capacity) {
        elems = new Object[capacity];
    }

    public ArrayList() {
        this(16);
    }

    public void add(E e) {
        if (next == elems.length) {
            elems = Arrays.copyOf(elems, elems.length * 2);
        }

        elems[next++] = e;
    }

    public E get(int index) {
        return (E) elems[index];
    }

    public int size() {
        return next;
    }

    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);

        final int size = this.next;
        for (int i=0; i < size; i++) {
            action.accept((E)elems[i]);
        }

    }

    public ArrayList<E> filter(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);

        ArrayList<E> remainElem = new ArrayList<>();

        final int size = next;
        for (int i=0, k=0; i < size; i++) {
            @SuppressWarnings("unchecked")
            final E element = (E) elems[i];
            if (filter.test(element)) {
                remainElem.add(element);
            }
        }

        return remainElem;
    }

    public ArrayList<E> map(Function<? super E, ? extends E> mapper) {
        Objects.requireNonNull(mapper);

        final int size = this.next;
        ArrayList<E> mapElem = new ArrayList<>();
        for (int i=0; i < size; i++) {
            mapElem.add(mapper.apply((E)elems[i]));
        }

        return mapElem;
    }

    public Optional<E> reduce(E identity, BinaryOperator<E> accumulator) {
        Objects.requireNonNull(accumulator);

        final int size = this.next;
        if (size == 0) {
            return null;
        }

        E res = identity;
        for (int i=0; i < size; i++) {
            res = accumulator.apply(res, (E)elems[i]);
        }

        return Optional.ofNullable(res);
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        numbers.add(11);
        numbers.add(12);

        numbers.filter(n -> n > 5).forEach(out::println);

        numbers.map(n -> n * 2).forEach(out::println);

        out.println(numbers.reduce(0, (total, n) -> total + n).orElse(0));
    }

}
