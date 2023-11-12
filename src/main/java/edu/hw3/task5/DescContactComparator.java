package edu.hw3.task5;

import java.util.Comparator;

public class DescContactComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {

        String name1 = (o1.getSurname() == null) ? o1.getFirstname() : o1.getSurname();
        String name2 = (o2.getSurname() == null) ? o2.getFirstname() : o2.getSurname();

        return -name1.compareTo(name2);

    }
}
