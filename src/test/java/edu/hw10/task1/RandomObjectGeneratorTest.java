package edu.hw10.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomObjectGeneratorTest {
    @Test
    void Test()
    {
        RandomObjectGenerator generator = new RandomObjectGenerator();
        Person person = generator.nextObject(Person.class);

        assertThat(person.getAge()).isBetween(0, 60);
        assertNotNull(person.getName());
    }

}
