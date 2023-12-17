package edu.hw10.task1;

public class Person {
    private int age;
    private String name;

    public Person(@Min(value = 0) @Max(value = 60) int age, @NotNull String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
