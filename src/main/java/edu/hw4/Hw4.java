package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hw4 {

    private Hw4() {

    }

    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    public static List<Animal> task2(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
            ));
    }

    public static Animal task4(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(o -> o.name().length())).get();
    }

    public static Animal.Sex task5(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(
                Animal::sex,
                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
            ))
            .entrySet()
            .stream()
            .max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Animal::weight)), Optional::get)
            ));
    }

    public static Animal task7(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .toList()
            .get(k);
    }

    public static Optional<Animal> task8(List<Animal> animals, int k) {
        return animals.stream()
            .filter(o -> o.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer task9(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static List<Animal> task10(List<Animal> animals) {
        return animals.stream()
            .filter(o -> o.age() != o.paws())
            .toList();
    }

    public static List<Animal> task11(List<Animal> animals) {
        final int minHeight = 100;
        return animals.stream()
            .filter(o -> o.bites() && o.height() > minHeight)
            .toList();
    }

    public static List<Animal> task12(List<Animal> animals) {
        return animals.stream()
            .filter(o -> o.weight() > o.height())
            .toList();
    }

    public static List<Animal> task13(List<Animal> animals) {
        return animals.stream()
            .filter(o -> o.name().split(" ").length > 2)
            .toList();
    }

    public static boolean task14(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(o -> o.type() == Animal.Type.DOG && o.height() > k);
    }

    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(o -> o.age() >= k && o.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .sorted((o1, o2) -> {
                int firstComp = o1.type().compareTo(o2.type());
                if (firstComp != 0) {
                    return firstComp;
                }

                int secondComp = o1.sex().compareTo(o2.sex());
                if (secondComp != 0) {
                    return secondComp;
                }

                return o1.name().compareTo(o2.name());
            })
            .toList();
    }

    public static Animal task18(List<Animal> firstlList, List<Animal> secondList) {
        return Stream.concat(firstlList.stream(), secondList.stream())
            .filter(o -> o.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight)).get();
    }
}
