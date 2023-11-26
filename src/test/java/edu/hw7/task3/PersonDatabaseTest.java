package edu.hw7.task3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonDatabaseTest {

    static Stream<PersonDatabase> factory() {
        return Stream.of(new SynchronizedPersonDatabase(), new ReadWritePersonDatabase());
    }

    @ParameterizedTest
    @MethodSource("factory")
    void test(PersonDatabase personDatabase) {
        Person person = new Person(5, "name", "address", "phone");

        Thread addingThread = new Thread(() -> {
            personDatabase.add(person);
            personDatabase.add(new Person(2, "n", "a", "p"));
        });
        Thread findingThread = new Thread(() -> {
            assertThat(personDatabase.findByName("name")).isEqualTo(List.of(person));
            assertThat(personDatabase.findByAddress("address")).isEqualTo(List.of(person));
            assertThat(personDatabase.findByPhone("phone")).isEqualTo(List.of(person));
        });

        addingThread.start();
        findingThread.start();

        assertAll(addingThread::join);
        assertAll(findingThread::join);
    }
}
