package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    @DisplayName("Task 4")
    void test() {
        List<String> input = List.of(
            "dfsdgsd",
            "ihfdsbhweg",
            "ikhdf~2134",
            "!fdsfsdf",
            "jdfgjk@",
            "jksdfjb$gm",
            "%%%%",
            "^_^",
            "login&password",
            "|aaaaa|",
            "fail",
            "|^_^ not Fail 100%!|",
            "_ not Fail 100"
        );
        List<Boolean> output =
            List.of(false, false, true, true, true, true, true, true, true, true, false, true, false);

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task4.validatePassword(input.get(i))).isEqualTo(output.get(i));
        }
    }

}
