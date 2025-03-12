package cholog.list;

import java.util.Arrays;

public interface SimpleList<E> {

    boolean add(E value);

    void add(int index, E value);

    E set(int index, E value);

    E get(int index);

    boolean contains(E value);

    int indexOf(E value);

    int size();

    boolean isEmpty();

    boolean remove(E value);

    E remove(int index);

    void clear();

    static <E> SimpleList<E> fromArrayToList(E[] values) {
        SimpleArrayList<E> simpleArrayList = new SimpleArrayList<>();
        Arrays.stream(values).forEach(simpleArrayList::add);
        return simpleArrayList;
    }

    static double sum(SimpleList<? extends Number> simpleList) {
        double total = 0;
        for (int i = 0; i < simpleList.size(); i++) {
            total += simpleList.get(i).doubleValue();
        }
        return total;
    }

    static <E extends Number> SimpleList<E> filterNegative(SimpleList<E> simpleList) {
        for (int i = 0; i < simpleList.size(); i++) {
            if (simpleList.get(i).doubleValue() < 0) {
                simpleList.remove(i);
            }
        }
        return simpleList;
    }

    static <T> void copy(SimpleList<? extends T> list1, SimpleList<? super T> list2) {
        for (int i = 0; i < list1.size(); i++) {
            list2.add(list1.get(i));
        }
    }
}
