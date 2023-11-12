package edu.hw3.task5;

import java.util.ArrayList;
import java.util.List;

public class Task5 {

    private Task5() {
    }

    static List<Contact> parseContact(List<String> names, String sortingMethod) {
        List<Contact> contacts = new ArrayList<>();

        for (String name : names) {
            String[] splittedName = name.split(" ");

            if (splittedName.length == 1) {
                contacts.add(new Contact(splittedName[0]));
            } else {
                contacts.add(new Contact(splittedName[0], splittedName[1]));
            }
        }

        switch (sortingMethod) {
            case "ASC" -> contacts.sort(new AscContactComparator());
            case "DESC" -> contacts.sort(new DescContactComparator());
            default -> throw new IllegalArgumentException();
        }

        return contacts;
    }
}
