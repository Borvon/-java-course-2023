package edu.hw7.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWritePersonDatabase implements PersonDatabase {

    private final Map<Integer, Person> personMap = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            personMap.put(person.id(), person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            personMap.remove(id);
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return personMap
                .values()
                .stream()
                .filter(o -> o.name().equals(name))
                .toList();
        } finally {
            lock.readLock().unlock();
        }

    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return personMap
                .values()
                .stream()
                .filter(o -> o.address().equals(address))
                .toList();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return personMap
                .values()
                .stream()
                .filter(o -> o.phoneNumber().equals(phone))
                .toList();
        } finally {
            lock.readLock().unlock();
        }
    }
}
