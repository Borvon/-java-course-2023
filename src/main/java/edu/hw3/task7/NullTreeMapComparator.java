package edu.hw3.task7;

import java.util.Comparator;

public class NullTreeMapComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {

        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        }

        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
}
