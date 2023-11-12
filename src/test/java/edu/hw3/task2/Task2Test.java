package edu.hw3.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task2Test {
    @Test
    @DisplayName("Task 2")
    void test() {
        String[] input = new String[] {"()()()", "((()))", "((()))(())()()(()())", "((())())(()(()()))"};
        ArrayList<ArrayList<String>> output = new ArrayList<>();

        //test1
        ArrayList<String> test1 = new ArrayList<>();
        test1.add("()");
        test1.add("()");
        test1.add("()");
        output.add(test1);

        //test2
        ArrayList<String> test2 = new ArrayList<>();
        test2.add("((()))");
        output.add(test2);

        //test3
        ArrayList<String> test3 = new ArrayList<>();
        test3.add("((()))");
        test3.add("(())");
        test3.add("()");
        test3.add("()");
        test3.add("(()())");
        output.add(test3);

        //test4
        ArrayList<String> test4 = new ArrayList<>();
        test4.add("((())())");
        test4.add("(()(()()))");
        output.add(test4);

        for (int i = 0; i < input.length; i++) {
            assertThat(Task2.clusterize(input[i])).isEqualTo(output.get(i));
        }
    }

    @Test
    @DisplayName("Task 2")
    void testException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Task2.clusterize("(())(()(())");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Task2.clusterize("(())())(())");
        });

    }
}
