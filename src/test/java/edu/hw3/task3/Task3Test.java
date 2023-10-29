package edu.hw3.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task3Test {
    @Test
    @DisplayName("Task 3")
    void test() {
        ArrayList<ArrayList<Object>> input = new ArrayList<>();
        ArrayList<Map<Object, Integer>> output = new ArrayList<>();

        //test1
        ArrayList<Object> input1 = new ArrayList<>();
        Map<Object, Integer> output1 = new HashMap<>();
        input1.add("a");
        input1.add("bb");
        input1.add("a");
        input1.add("bb");
        output1.put("a", 2);
        output1.put("bb", 2);
        input.add(input1);
        output.add(output1);

        //test2
        ArrayList<Object> input2 = new ArrayList<>();
        Map<Object, Integer> output2 = new HashMap<>();
        input2.add("this");
        input2.add("and");
        input2.add("that");
        input2.add("and");
        output2.put("this", 1);
        output2.put("that", 1);
        output2.put("and", 2);
        input.add(input2);
        output.add(output2);

        //test3
        ArrayList<Object> input3 = new ArrayList<>();
        Map<Object, Integer> output3 = new HashMap<>();
        input3.add("код");
        input3.add("код");
        input3.add("код");
        input3.add("bug");
        output3.put("код", 3);
        output3.put("bug", 1);
        input.add(input3);
        output.add(output3);

        //test4
        ArrayList<Object> input4 = new ArrayList<>();
        Map<Object, Integer> output4 = new HashMap<>();
        input4.add(1);
        input4.add(1);
        input4.add(2);
        input4.add(2);
        output4.put(1, 2);
        output4.put(2, 2);
        input.add(input4);
        output.add(output4);

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task3.freqDict(input.get(i))).isEqualTo(output.get(i));
        }
    }
}
