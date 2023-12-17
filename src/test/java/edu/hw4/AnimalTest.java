package edu.hw4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

class AnimalTest {

    static List<Animal> animalsList = new ArrayList<>();
    static Map<String, Animal> animals = new HashMap<>();

    @BeforeAll
    static void createAnimalList() {
        animalsList.add(new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 6, 25, 7, true));
        animalsList.add(new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 4, 23, 5, true));
        animalsList.add(new Animal("Alabai)))", Animal.Type.DOG, Animal.Sex.M, 9, 60, 40, false));
        animalsList.add(new Animal("Abeliv Acenfly", Animal.Type.BIRD, Animal.Sex.F, 4, 30, 1, false));
        animalsList.add(new Animal("There is more than three words", Animal.Type.BIRD, Animal.Sex.F, 3, 35, 2, false));
        animalsList.add(new Animal("SimpleFish", Animal.Type.FISH, Animal.Sex.M, 10, 15, 2, false));
        animalsList.add(new Animal("HeavyFish", Animal.Type.FISH, Animal.Sex.F, 11, 210, 200, true));
        animalsList.add(new Animal("ExtremelyHeavyFish", Animal.Type.FISH, Animal.Sex.M, 12, 150, 20000, true));
        animalsList.add(new Animal("Pavook", Animal.Type.SPIDER, Animal.Sex.F, 8, 0, 0, true));

        for (Animal animal : animalsList) {
            animals.put(animal.name(), animal);
        }
    }

    @Test
    @DisplayName("Task 1")
    void task1() {
        List<Animal> sorted = new ArrayList<>();

        sorted.add(new Animal("Pavook", Animal.Type.SPIDER, Animal.Sex.F, 8, 0, 0, true));
        sorted.add(new Animal("SimpleFish", Animal.Type.FISH, Animal.Sex.M, 10, 15, 2, false));
        sorted.add(new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 4, 23, 5, true));
        sorted.add(new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 6, 25, 7, true));
        sorted.add(new Animal("Abeliv Acenfly", Animal.Type.BIRD, Animal.Sex.F, 4, 30, 1, false));
        sorted.add(new Animal("There is more than three words", Animal.Type.BIRD, Animal.Sex.F, 3, 35, 2, false));
        sorted.add(new Animal("Alabai)))", Animal.Type.DOG, Animal.Sex.M, 9, 60, 40, false));
        sorted.add(new Animal("ExtremelyHeavyFish", Animal.Type.FISH, Animal.Sex.M, 12, 150, 20000, true));
        sorted.add(new Animal("HeavyFish", Animal.Type.FISH, Animal.Sex.F, 11, 210, 200, true));

        assertThat(Hw4.task1(animalsList)).isEqualTo(sorted);
    }

    @Test
    @DisplayName("Task 2")
    void task2() {
        assertThat(Hw4.task2(animalsList, 3)).isEqualTo(List.of(
            animals.get("ExtremelyHeavyFish"),
            animals.get("HeavyFish"),
            animals.get("Alabai)))")
        ));
    }

    @Test
    @DisplayName("Task 3")
    void task3() {
        Map<Animal.Type, Integer> result = new HashMap<>();
        result.put(Animal.Type.CAT, 2);
        result.put(Animal.Type.DOG, 1);
        result.put(Animal.Type.BIRD, 2);
        result.put(Animal.Type.FISH, 3);
        result.put(Animal.Type.SPIDER, 1);

        assertThat(Hw4.task3(animalsList)).isEqualTo(result);
    }

    @Test
    @DisplayName("Task 4")
    void task4() {
        assertThat(Hw4.task4(animalsList).name()).isEqualTo("There is more than three words");
    }

    @Test
    @DisplayName("Task 5")
    void task5() {
        assertThat(Hw4.task5(animalsList)).isEqualTo(Animal.Sex.M);
    }

    @Test
    @DisplayName("Task 6")
    void task6() {
        Map<Animal.Type, Animal> result = new HashMap<>();
        result.put(Animal.Type.CAT, animals.get("Cat1"));
        result.put(Animal.Type.DOG, animals.get("Alabai)))"));
        result.put(Animal.Type.BIRD, animals.get("There is more than three words"));
        result.put(Animal.Type.FISH, animals.get("ExtremelyHeavyFish"));
        result.put(Animal.Type.SPIDER, animals.get("Pavook"));

        assertThat(Hw4.task6(animalsList)).isEqualTo(result);
    }

    @Test
    @DisplayName("Task 7")
    void task7() {
        assertThat(Hw4.task7(animalsList, 0).name()).isEqualTo("ExtremelyHeavyFish");
        assertThat(Hw4.task7(animalsList, 1).name()).isEqualTo("HeavyFish");
        assertThat(Hw4.task7(animalsList, 3).name()).isEqualTo("Alabai)))");
    }

    @Test
    @DisplayName("Task 8")
    void task8() {
        assertThat(Hw4.task8(animalsList, 151).get().name()).isEqualTo("ExtremelyHeavyFish");
        assertThat(Hw4.task8(animalsList, 150).get().name()).isEqualTo("Alabai)))");
        assertThat(Hw4.task8(animalsList, 25).get().name()).isEqualTo("Cat2");
    }

    @Test
    @DisplayName("Task 9")
    void task9() {
        assertThat(Hw4.task9(animalsList)).isEqualTo(24);
    }

    @Test
    @DisplayName("Task 10")
    void task10() {
        List<Animal> result = new ArrayList<>(animalsList);
        result.remove(animals.get("Cat2"));
        result.remove(animals.get("Pavook"));

        assertThat(Hw4.task10(animalsList)).isEqualTo(result);
    }

    @Test
    @DisplayName("Task 11")
    void task11() {
        List<Animal> result = new ArrayList<>();
        result.add(animals.get("HeavyFish"));
        result.add(animals.get("ExtremelyHeavyFish"));

        assertThat(Hw4.task11(animalsList)).isEqualTo(result);
    }

    @Test
    @DisplayName("Task 12")
    void task12() {
        List<Animal> result = new ArrayList<>();
        result.add(animals.get("ExtremelyHeavyFish"));

        assertThat(Hw4.task12(animalsList)).isEqualTo(result);
    }

    @Test
    @DisplayName("Task 13")
    void task13() {
        List<Animal> result = new ArrayList<>();
        result.add(animals.get("There is more than three words"));

        assertThat(Hw4.task13(animalsList)).isEqualTo(result);
    }

    @Test
    @DisplayName("Task 14")
    void task14() {
        assertThat(Hw4.task14(animalsList, 59)).isEqualTo(true);
        assertThat(Hw4.task14(animalsList, 60)).isEqualTo(false);
    }

    @Test
    @DisplayName("Task 15")
    void task15() {
        Map<Animal.Type, Integer> allAnimals = new HashMap<>();
        allAnimals.put(Animal.Type.CAT, 12);
        allAnimals.put(Animal.Type.DOG, 40);
        allAnimals.put(Animal.Type.BIRD, 3);
        allAnimals.put(Animal.Type.FISH, 20202);
        allAnimals.put(Animal.Type.SPIDER, 0);

        Map<Animal.Type, Integer> notAllAnimals = new HashMap<>();
        notAllAnimals.put(Animal.Type.CAT, 7);
        notAllAnimals.put(Animal.Type.DOG, 40);
        notAllAnimals.put(Animal.Type.FISH, 202);
        notAllAnimals.put(Animal.Type.SPIDER, 0);

        assertThat(Hw4.task15(animalsList, 0, 100)).isEqualTo(allAnimals);
        assertThat(Hw4.task15(animalsList, 6, 11)).isEqualTo(notAllAnimals);
    }

    @Test
    @DisplayName("Task 16")
    void task16() {
        List<Animal> result = new ArrayList<>();

        result.add(new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 6, 25, 7, true));
        result.add(new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 4, 23, 5, true));
        result.add(new Animal("Alabai)))", Animal.Type.DOG, Animal.Sex.M, 9, 60, 40, false));
        result.add(new Animal("Abeliv Acenfly", Animal.Type.BIRD, Animal.Sex.F, 4, 30, 1, false));
        result.add(new Animal("There is more than three words", Animal.Type.BIRD, Animal.Sex.F, 3, 35, 2, false));
        result.add(new Animal("ExtremelyHeavyFish", Animal.Type.FISH, Animal.Sex.M, 12, 150, 20000, true));
        result.add(new Animal("SimpleFish", Animal.Type.FISH, Animal.Sex.M, 10, 15, 2, false));
        result.add(new Animal("HeavyFish", Animal.Type.FISH, Animal.Sex.F, 11, 210, 200, true));
        result.add(new Animal("Pavook", Animal.Type.SPIDER, Animal.Sex.F, 8, 0, 0, true));

        assertThat(Hw4.task16(animalsList)).isEqualTo(result);
    }

    @Test
    @DisplayName("Task 18")
    void task18() {
        List<Animal> secondList = new ArrayList<>();
        assertThat(Hw4.task18(animalsList, secondList).name()).isEqualTo("ExtremelyHeavyFish");
        secondList.add(new Animal("Heavy)", Animal.Type.FISH, Animal.Sex.M, 12, 150, 20001, true));
        assertThat(Hw4.task18(animalsList, secondList).name()).isEqualTo("Heavy)");
    }

}
