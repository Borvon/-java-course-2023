package edu.hw7.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedPersonDatabase implements PersonDatabase {

    private final Map<Integer, Person> personMap = new HashMap<>();

    @Override
    public void add(Person person) {
        synchronized (personMap) {
            personMap.put(person.id(), person);
        }
    }

    @Override
    public void delete(int id) {
        synchronized (personMap) {
            personMap.remove(id);
        }
    }

    @Override
    public List<Person> findByName(String name) {
        synchronized (personMap) {
            return personMap
                .values()
                .stream()
                .filter(o -> o.name().equals(name))
                .toList();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        synchronized (personMap) {
            return personMap
                .values()
                .stream()
                .filter(o -> o.address().equals(address))
                .toList();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        synchronized (personMap) {
            return personMap
                .values()
                .stream()
                .filter(o -> o.phoneNumber().equals(phone))
                .toList();
        }
    }
}
