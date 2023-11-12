package edu.hw3.task8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BackwardIterator<E> implements Iterator<E> {

    private final List<E> list = new ArrayList<>();

    public BackwardIterator(Iterable<E> iterable) {
        iterable.iterator().forEachRemaining(list::add);
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public E next() {
        E result = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return result;
    }
}
