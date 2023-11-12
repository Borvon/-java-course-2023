package edu.hw3.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Task 1")
    void test() {
        String[] input = new String[] {"Hello world!",
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler"};
        String[] output = new String[] {"Svool dliow!",
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"};

        for (int i = 0; i < input.length; i++) {
            assertThat(Task1.atbash(input[i])).isEqualTo(output[i]);
        }
    }
}
