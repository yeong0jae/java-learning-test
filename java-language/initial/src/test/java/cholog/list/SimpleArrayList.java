package cholog.list;

import java.util.Arrays;
import java.util.Objects;

public class SimpleArrayList<E> implements SimpleList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final Object[] EMPTY_ELEMENTDATA = {};

    Object[] elementData;

    private int size;

    public SimpleArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        }
        this.elementData = new Object[initialCapacity];
    }

    @Override
    public boolean add(E value) {
        add(value, elementData, size);
        return true;
    }

    private void add(E value, Object[] elementData, int size) {
        if (size == elementData.length) {
            elementData = grow(size + 1);
        }
        elementData[size] = value;
        this.size = size + 1;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            // 1.5배로 늘리는 로직
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        }
        return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
    }

    @Override
    public void add(int index, E value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length) {
            elementData = grow(s + 1);
        }
        System.arraycopy(
                elementData, index, // 복사할 원본 배열, 복사할 원본 배열의 시작 인덱스
                elementData, index + 1, // 복사해서 붙여넣을 대상 배열, 붙여넣을 대상 배열의 시작 인덱스
                s - index // 얼마나 복사할지
        );
        elementData[index] = value;
        size = s + 1;
    }

    @Override
    public E set(int index, E value) {
        Objects.checkIndex(index, size);
        E oldValue = (E) elementData[index];
        elementData[index] = value;
        return oldValue;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(E value) {
        Object[] es = elementData;
        for (int i = 0; i < size; i++) {
            if (value.equals(es[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E value) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        for (; i < size; i++) {
            if (value.equals(es[i])) {
                break;
            }
        }
        if (i == size) {
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i) {
            System.arraycopy(
                    es, i + 1,
                    es, i,
                    newSize - i
            );
        }
        es[size = newSize] = null;
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }

    @Override
    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++) {
            es[i] = null;
        }
    }
    
}
