package edu.hw3.task5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task5Test {

    @Test
    @DisplayName("Task 5")
    void test() {
        ArrayList<ArrayList<String>> input = new ArrayList<>();
        ArrayList<ArrayList<Contact>> output = new ArrayList<>();
        ArrayList<String> methods = new ArrayList<>();

        //test1
        methods.add("ASC");
        ArrayList<String> input1 = new ArrayList<>();
        ArrayList<Contact> output1 = new ArrayList<>();
        input1.add("John Locke");
        input1.add("Thomas Aquinas");
        input1.add("David Hume");
        input1.add("Rene Descartes");
        output1.add(new Contact("Thomas", "Aquinas"));
        output1.add(new Contact("Rene", "Descartes"));
        output1.add(new Contact("David", "Hume"));
        output1.add(new Contact("John", "Locke"));
        input.add(input1);
        output.add(output1);

        //test2
        methods.add("DESC");
        ArrayList<String> input2 = new ArrayList<>();
        ArrayList<Contact> output2 = new ArrayList<>();
        input2.add("Paul Erdos");
        input2.add("Leonhard Euler");
        input2.add("Carl Gauss");
        output2.add(new Contact("Carl", "Gauss"));
        output2.add(new Contact("Leonhard", "Euler"));
        output2.add(new Contact("Paul", "Erdos"));
        input.add(input2);
        output.add(output2);

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task5.parseContact(input.get(i), methods.get(i)).toString()).isEqualTo(output.get(i).toString());
        }
    }

    @Test
    @DisplayName("Task 5")
    void testException()
    {
        ArrayList<String> input = new ArrayList<>();
        ArrayList<Contact> output = new ArrayList<>();
        input.add("John Locke");
        input.add("Thomas Aquinas");
        input.add("David Hume");
        input.add("Rene Descartes");
        output.add(new Contact("Thomas", "Aquinas"));
        output.add(new Contact("Rene", "Descartes"));
        output.add(new Contact("David", "Hume"));
        output.add(new Contact("John", "Locke"));

        assertThrows(IllegalArgumentException.class, () -> {
            Task5.parseContact(input, "HELPME");
        });
    }

}
